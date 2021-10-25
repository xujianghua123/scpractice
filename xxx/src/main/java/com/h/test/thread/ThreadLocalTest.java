package com.h.test.thread;

public class ThreadLocalTest {

    private static ThreadLocal<String> cache = new ThreadLocal<>();

    public static void main(String[] args) {
        cache.set("thread info-" + Thread.currentThread().getName());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                cache.set("t1");
                System.out.println(cache.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                cache.set("t2");
                System.out.println(cache.get());
            }
        });

        t1.start();
        t2.start();


        cache.set("222222");
        System.out.println(cache.get());
        System.out.println(cache.get());

    }
}
