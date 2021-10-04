package com.h.test.thread;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {


    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("thread1  start");
                lock1.lock();
                Thread.sleep(50000);
                System.out.println("thread1 -------- end");
                lock2.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("thread2  start");
                lock2.lock();
                Thread.sleep(50000);
                System.out.println("thread2 --------- end");
                lock1.unlock();
            }
        }).start();
    }
}
