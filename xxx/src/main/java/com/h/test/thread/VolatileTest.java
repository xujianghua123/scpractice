package com.h.test.thread;

import java.util.PriorityQueue;

public class VolatileTest {
    // JMM模型  java线程内存模型
    // 可见性    为什么？     lock addl $0x0,(%rsp)  触发缓存一致性协议
    private volatile boolean  flag = true;

    public void refresh(){
        flag = false;
        System.out.println(Thread.currentThread().getName()+"修改flag");
    }

    public void load(){
        System.out.println(Thread.currentThread().getName()+"开始执行.....");
        int i=0;
        while (flag){
            i++;
            //TODO
            // 不能
            // 能
            //shortWait(100000);
            // 不能   迷   为什么？   缓存是否失效（过期）
            //shortWait(10000);

            // 能    synchronized 可见性保证  内存屏障
            // System.out.println("=====");
//            try {
//                // 能   sleep 让出cpu时间片
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            new PriorityQueue<>();

        }
        System.out.println(Thread.currentThread().getName()+"跳出循环: i="+ i);
    }

    public static void main(String[] args){

        VolatileTest test = new VolatileTest();
        new Thread(() -> test.load(), "threadA").start();
        try {
            Thread.sleep(2000);
            new Thread(()->test.refresh(),"threadB").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }



}