package com.h.test.t;

import java.util.PriorityQueue;
import java.util.Queue;

public class FClass {

    private Queue<Integer> msg = new PriorityQueue<Integer>();
    public static void main(String[] args) {
        FClass m = new FClass();
        m.producer();

        m.consumer();
    }

    public void producer(){
        int i = 0;
        while(i<100){
            msg.add(i);
            i++;
        }

    }

    public void consumer(){
        while(msg.size()>0){
            System.out.println(msg.remove());
        }
    }

}
