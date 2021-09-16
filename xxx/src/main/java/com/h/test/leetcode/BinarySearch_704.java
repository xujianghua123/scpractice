package com.h.test.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearch_704 {

    private Queue<Integer> minQueue;
    private Queue<Integer> maxQueue;
    public BinarySearch_704() {
        minQueue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        maxQueue = new PriorityQueue();
    }


    public int search(int[] nums, int target) {
        PriorityQueue priorityQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        return search(nums,target,0,nums.length - 1);
    }

    private int search(int[] nums, int target,int begIndex,int endIndex){

        if(nums[(begIndex + endIndex) / 2]  == target){
            return (begIndex + endIndex) / 2;
        }else if(begIndex == endIndex && nums[begIndex] != target){
            return -1;
        }else if(nums[(begIndex + endIndex) / 2] > target){
            return search(nums,target,begIndex,(begIndex + endIndex) / 2);
        }else {
            return search(nums,target,(begIndex + endIndex) / 2 - 1,endIndex);
        }
    }
}
