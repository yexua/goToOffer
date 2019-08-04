package thread;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CustomThreadPool {

    private final ReentrantLock lock = new ReentrantLock();

    private volatile int minimumPoolSize;
    private volatile int maximumPoolSize;
    private Long keepAliveTime;
    private TimeUnit unit;
    private BlockingQueue<Runnable> workQueue;
    private Notify notify;
//    ThreadPoolExecutor

    private volatile ConcurrentHashSet<Worker> workers;

    /**
     * 是否关闭线程池标志
     */
    private AtomicBoolean isShutDown = new AtomicBoolean(false);
    /**
     * 提交到线程池中的任务总数
     */
    private AtomicInteger totalTask = new AtomicInteger();
    /**
     * 线程池任务全部执行完毕后的通知组件
     */
    private final Object shutDownNotify = new Object();




    private final class Worker extends Thread {
        private Runnable task;

        private Thread thread;

        private boolean isNewTask;

        Worker(Runnable task, boolean isNewTask) {
            this.task = task;
            this.isNewTask = isNewTask;
            thread = this;
        }

        void startTask() {
            thread.start();
        }


        @Override
        public void run() {
            Runnable task = null;

            if (isNewTask) {
                task = this.task;
            }

            boolean compile = true;

            try {
                while ((task != null || (task = getTask()) != null)) {
                    try {
                        //执行任务
                        task.run();
                    } catch (Exception e) {
                        compile = false;
                        throw e;
                    } finally {
                        //任务执行完毕
                        task = null;
                        int number = totalTask.decrementAndGet();
                        //LOGGER.info("number={}",number);
                        if (number == 0) {
                            synchronized (shutDownNotify) {
//                                notify.notifyListen();
                                shutDownNotify.notify();
                            }
                        }
                    }
                }

            } finally {
                //释放线程
                boolean remove = workers.remove(this);
                //LOGGER.info("remove={},size={}", remove, workers.size());

                if (!compile) {
                    addWorker(null);
                }
                tryClose(true);
            }
        }

        void close() {
            thread.interrupt();
        }

    }


    private void addWorker(Runnable runnable) {
        Worker worker = new Worker(runnable, true);
        worker.startTask();
        workers.add(worker);
    }

    private final class ConcurrentHashSet<T> extends AbstractSet<T> {

        private ConcurrentHashMap<T, Object> map = new ConcurrentHashMap<>();

        private final Object PRESENT = new Object();

        private AtomicInteger count = new AtomicInteger();

        @Override
        public Iterator<T> iterator() {
            return map.keySet().iterator();
        }

        @Override
        public boolean add(T t) {
            count.incrementAndGet();
            return map.put(t, PRESENT) == null;
        }

        @Override
        public boolean remove(Object o) {
            count.decrementAndGet();
            return map.remove(o) == null;
        }

        @Override
        public int size() {
            return count.get();
        }
    }

    /**
     * @param minimumPoolSize 最小线程数
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime   线程存活时间
     * @param unit            时间单位
     * @param workQueue       阻塞队列
     * @param notify          通知接口
     */
    public CustomThreadPool(int minimumPoolSize, int maximumPoolSize, Long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, Notify notify) {
        this.minimumPoolSize = minimumPoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.workQueue = workQueue;
        this.notify = notify;

        workers = new ConcurrentHashSet<>();
    }


    public void execute(Runnable runnable) {
        if (runnable == null) {
//            throw new NullPointerException("runnable nullPointerException");
            throw new NullPointerException();
        }
        if (isShutDown.get()) {
            System.out.println("线程池已经关闭，不能再提交任务");
            return;
        }
        //提交的线程 计数
        totalTask.incrementAndGet();

        if (workers.size() < minimumPoolSize) {
            addWorker(runnable);
            return;
        }

        boolean offer = workQueue.offer(runnable);
        if (!offer) {
            if(workers.size() < maximumPoolSize){
                addWorker(runnable);
                return;
            }else{
                System.out.println("超过最大线程数");
                try {
                    workQueue.put(runnable);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private Runnable getTask() {
        //关闭标识及任务是否全部完成
        if (isShutDown.get() && totalTask.get() == 0) {
            return null;
        }
        //while (true) {
        //
        //    if (workers.size() > miniSize) {
        //        boolean value = number.compareAndSet(number.get(), number.get() - 1);
        //        if (value) {
        //            return null;
        //        } else {
        //            continue;
        //        }
        //    }

        lock.lock();

        try {
            Runnable task = null;
            if (workers.size() > minimumPoolSize) {
                //大于核心线程数时需要用保活时间获取任务
                task = workQueue.poll(keepAliveTime, unit);
            } else {
                task = workQueue.take();
            }

            if (task != null) {
                return task;
            }
        } catch (InterruptedException e) {
            return null;
        } finally {
            lock.unlock();
        }

        return null;

    }


    /**
     * 立即关闭线程池，会造成任务丢失
     */
    public void shutDownNow() {
        isShutDown.set(true);
        tryClose(false);
    }

    /**
     * 任务执行完毕后关闭线程池
     */
    public void shutdown() {
        isShutDown.set(true);
        tryClose(true);
    }

    public void mainNotify() {
        synchronized (shutDownNotify) {
            while (totalTask.get() > 0) {
                try {
                    shutDownNotify.wait();
                    if (notify != null) {
                        notify.notifyListen();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }


    /**
     * 关闭线程池
     *
     * @param isTry true 尝试关闭      --> 会等待所有任务执行完毕
     *              false 立即关闭线程池--> 任务有丢失的可能
     */
    private void tryClose(boolean isTry) {
        if (!isTry) {
            closeAllTask();
        } else {
            if (isShutDown.get() && totalTask.get() == 0) {
                closeAllTask();
            }
        }
    }

    /**
     * 关闭所有任务
     */
    private void closeAllTask() {
        for (Worker worker : workers) {
            //LOGGER.info("开始关闭");
            worker.close();
        }
    }

    /**
     * 获取工作线程数量
     *
     * @return
     */
    public int getWorkerCount() {
        return workers.size();
    }

}
