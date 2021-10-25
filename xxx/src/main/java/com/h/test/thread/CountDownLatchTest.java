package com.h.test.thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    private final CountDownLatch countDownLatch = new CountDownLatch(3);
    @Test
    public void test() throws Exception{
        long startTime = System.currentTimeMillis();
//        for(int i = 0;i < 5;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    countDownLatch.countDown();
//                    System.out.println(Thread.currentThread().getName());
//                }
//            }).start();
//        }
//        countDownLatch.await();

        Executors.newFixedThreadPool(5).execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " start");
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " end");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        try {
            System.out.println("wait ---- start");
            countDownLatch.await();
            System.out.println("wait ---- end");
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 3;i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  start");
                        Thread.sleep(3000);
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + "  end");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        try {
            System.out.println("wait ---- start");
            countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            System.out.println("wait ---- end");
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
