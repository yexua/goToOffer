package thread;

import java.util.concurrent.*;

public class PoolTest {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(8);
        CustomThreadPool pool = new CustomThreadPool(3, 5, 1L, TimeUnit.SECONDS, queue, ()-> System.out.println("任务执行完毕"));
        for (int i = 0; i < 10; i++) {
            pool.execute(new Resource(i));
        }

        System.out.println("==============休眠前线程池活跃线程数={" + pool.getWorkerCount() + "}==============");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("==============休眠后线程池活跃线程数={" + pool.getWorkerCount() + "}==============");
        for (int i = 0; i < 3; i++) {
            pool.execute(new Resource(i + 100));
        }
        pool.shutdown();
        pool.mainNotify();
        System.out.println("==============当前线程池活跃线程数={" + pool.getWorkerCount() + "}==============");


    }
}

class Resource extends Thread {
    int state;

    public Resource(int state) {
        this.state = state;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "- state" + state);
    }
}
