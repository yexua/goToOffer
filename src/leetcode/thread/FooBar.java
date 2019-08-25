package leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;

    private Lock lock;
    private Condition fooCondition;
    private Condition barCondition;
    private boolean fooFlag;
    private boolean barFlag;

    public FooBar(int n) {
        this.n = n;
        lock = new ReentrantLock();
        fooCondition = lock.newCondition();
        barCondition = lock.newCondition();
        fooFlag = false;
        barFlag = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while(fooFlag){
                    fooCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooFlag = true;
                barFlag = false;
                barCondition.signal();
            }finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (barFlag) {
                    barCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barFlag = true;
                fooFlag = false;
                fooCondition.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar f = new FooBar(10);
        Runnable t1 = new FooRunnable();
        Runnable t2 = new BarRunnable();
        f.foo(t1);
        f.bar(t2);
    }

}
class FooRunnable implements Runnable{

    @Override
    public void run() {
        System.out.print("foo");
    }
}
class BarRunnable implements Runnable{

    @Override
    public void run() {
        System.out.print("bar");
    }
}