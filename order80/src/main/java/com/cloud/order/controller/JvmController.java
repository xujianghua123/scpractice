package com.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class JvmController {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    @GetMapping("consumer/jvm/deadLock")
    public void deadLockTest(){
        new Thread(()->{
            synchronized (lock1){
                System.out.println("thread1 begin!");
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("thread1 end!");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                System.out.println("thread2 begin!");
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("thread2 end!");
                }
            }
        }).start();

        System.out.println("main thread end!");
    }
}
