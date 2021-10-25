package com.h.test.spring.service;

import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

@Component
public class UserService {

    volatile PriorityQueue<Integer> msg = new PriorityQueue();

//    @AspectAnno("aspectTest")
    public void sayHi(){
        System.out.println("say hi~~");
    }

    public void sayHello(){
        System.out.println("say hello!");
    }
}
