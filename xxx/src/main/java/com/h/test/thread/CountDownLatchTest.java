package com.h.test.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private final CountDownLatch countDownLatch = new CountDownLatch(3);
    @Test
    public void test(){

        for(int i = 0;i < 5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.countDown();
                        countDownLatch.await();
                        System.out.println(Thread.currentThread().getName());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
