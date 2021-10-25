package com.h.test.thread;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    @Test
    public void test(){
        CyclicBarrier barrier = new CyclicBarrier(3);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 4;i++){
            bar(barrier);
        }

        System.out.println(System.currentTimeMillis() - startTime);

    }

    private void bar(CyclicBarrier barrier){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println(Thread.currentThread().getName() + " Start ~");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " End ~");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("线程执行完毕~~~");
            }
        }).start();
    }
}
