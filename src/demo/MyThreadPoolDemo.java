package demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        int core = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<String> list = Arrays.asList("a", "b", "c");
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //线程池中5个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 一池一个处理线程
        // ExecutorService threadPool = Executors.newCachedThreadPool();// 一池N个处理线程
        // 模拟10个用户办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}