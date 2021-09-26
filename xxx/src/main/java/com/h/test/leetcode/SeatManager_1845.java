package com.h.test.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager_1845 {

    private Queue<Integer> seatHeap = new PriorityQueue();

    public SeatManager_1845(int n) {
        for(int i = 1;i <= n;i++){
            seatHeap.add(i);
        }
    }

    public int reserve() {
        return seatHeap.poll();
    }

    public void unreserve(int seatNumber) {
        seatHeap.add(seatNumber);
    }
}
