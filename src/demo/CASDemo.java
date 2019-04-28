package demo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CASDemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("------ABA问题的产生--------");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                // 暂停1秒钟t2线程，保证上面的t1线程完成了一次ABA操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 200) + "\t" + atomicReference.get());
        }, "t2").start();
    }


    @Test
    public void test() {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 10) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 20) + "\t current data: " + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
