package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<Integer>{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableDemo());
        Thread t1 = new Thread(futureTask, "A");
        t1.start();

        System.out.println("result -> " + futureTask.get());
    }

    @Override
    public Integer call() {
        System.out.println("come in Callable");
        return 1024;
    }
}
