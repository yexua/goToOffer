package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLookDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone p = new Phone();

        new Thread(()->{
            try {
                p.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                p.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        TimeUnit.SECONDS.sleep(3);

        Thread t3 = new Thread(p, "t3");
        Thread t4 = new Thread(p, "t4");
        t3.start();
        t4.start();
    }
}

class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
        sendMail();
    }

    public synchronized void sendMail() throws Exception{
        System.out.println(Thread.currentThread().getName() + "\t invoked sendMail");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"\t invoked set()");
        } finally {
            lock.unlock();
        }

    }
}
