package com.flexhamp.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

//        for (int i = 0; i < 100; i++) {
//            System.out.println(futureTask.isDone());
//            System.out.println(i);
//            Thread.sleep(1000);
//        }

        int i = 0;
        while (!futureTask.isDone() || i > 100) {
            i++;
            System.out.println(i);
            if (i > 28)
                futureTask.cancel(true);
            Thread.sleep(1000);
        }

        final Integer result = futureTask.get();
        System.out.println(result);
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++) {
                Thread.sleep(3000);
            }
            return j;
        }
    }
}
