package com.h.test.leetcode;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class SmallestK_17_14 {

    @Test
    public void test(){
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        int[] ints = smallestK(arr, 4);
        for(int i:ints){
            System.out.print(i + "\t");
        }
    }

    public int[] smallestK(int[] arr, int k) {

        int[] res = new int[k];
        if(k == 0){
            return res;
        }

        Queue<Integer> smallQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0;i<arr.length;i++){

            if(smallQueue.size() < k){
                smallQueue.add(arr[i]);
                continue;
            }

            if(smallQueue.peek() <= arr[i]){
                continue;
            }

            smallQueue.remove();
            smallQueue.add(arr[i]);
        }

        for(int i = 0;i<k;i++){
            res[i] = smallQueue.remove();
        }
        return res;
    }
}
