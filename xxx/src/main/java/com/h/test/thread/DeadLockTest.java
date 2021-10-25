package com.h.test.thread;

import java.util.concurrent.TimeUnit;

public class DeadLockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    try {
                        Thread.sleep(5000);
                        wait(1, TimeUnit.SECONDS.hashCode());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread1  lock1");

                    synchronized (lock2){
                        System.out.println("thread1 lock2");
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread2  lock1");

                    synchronized (lock1){
                        System.out.println("thread2 lock2");
                    }
                }

            }
        }).start();
    }
}
