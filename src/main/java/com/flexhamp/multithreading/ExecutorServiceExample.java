package com.flexhamp.multithreading;

import com.flexhamp.util.Help;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        final ExecutorService es = Executors.newFixedThreadPool(5);

//        es.execute(new MyRunnable());

        final Future<?> sub1 = es.submit(new MyRunnable());

        final Future<?> sub2 = es.submit(new MyCallable());
//        Help.callOrNext(() -> System.out.println(sub2.get()));

        System.out.println("Shutdown");
        es.shutdown();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Start: " + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("Stop: " + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        try {
            System.out.println("Start: " + Thread.currentThread().getId());
            Thread.sleep(5000);
            System.out.println("Stop: " + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return 68;
    }
}
