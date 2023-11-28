package com.flexhamp.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        final ExecutorService es = Executors.newFixedThreadPool(5);

        es.execute(new MyRunnable());
        System.out.println("Waite");

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
