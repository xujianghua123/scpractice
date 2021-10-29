package com.cloud.consul.service;

import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    public String normal(){
        return "current Thread :" + Thread.currentThread().getName() + ", ok ^_^";
    }

    public String unNormal(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "current Thread :" + Thread.currentThread().getName() + ", sleep time(秒) " + 3;
    }
}
