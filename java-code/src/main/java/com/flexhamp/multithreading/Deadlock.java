package com.flexhamp.multithreading;

import com.flexhamp.util.Help;

import java.util.Optional;

public class Deadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        final Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (lock1) {

                Help.callOrNext(() ->Thread.sleep(100));
                synchronized (lock2) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }, "thread1");

        final Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (lock2) {
                synchronized (lock1) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }, "thread2");

        thread1.start();
        thread2.start();
    }

}
