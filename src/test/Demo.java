package test;

import java.util.HashSet;
import java.util.Hashtable;

public class Demo implements Runnable {

    Hashtable table;

    {
        table = new Hashtable();
        table.put("1", 1);
        table.put("2", 2);
        table.put("3", 3);
    }

    private String name;

    public Demo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        PriorityBlockingQueue
        Demo d = new Demo("11");
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        Thread t3 = new Thread(d);
        Thread t4 = new Thread(d);
        Thread t5 = new Thread(d);
        Thread t6 = new Thread(d);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        HashSet set = new HashSet();
    }


    @Override
    public void run() {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "完成");
        Thread.sleep(1000);
    }
}

