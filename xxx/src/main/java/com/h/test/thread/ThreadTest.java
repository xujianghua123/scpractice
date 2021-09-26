package com.h.test.thread;

import org.junit.Test;

public class ThreadTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        t1.run();
        t1.start();
    }

    @Test
    public void test(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                write();
                System.out.println(i);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(read());
            }
        });

        t2.start();
        t1.start();

    }

    private int i = 0;

    public void write(){
        i++;
    }

    public int read(){
        return i;
    }
}
