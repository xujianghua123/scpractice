package com.h.test.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class FindUnsortedSubarray_700 {

    @Test
    public void test(){
        int[] nums = {1,2,4,5,3};
        System.out.println(findUnsortedSubarray1(nums));
    }

    // n
    public int findUnsortedSubarray1(int[] nums) {

        int begin = -1,end = -1,max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for(int i = 1;i < nums.length ; i++){
            if(nums[i] < nums[i-1]){
                max = Math.max(nums[i-1] , max);
                min = Math.min(nums[i] , min);
            }
        }
        for(int i = 0;i < nums.length ; i++){
            if(begin == -1 && nums[i] > min){
                begin = i;
            }
            if(begin != -1 && nums[i] < max){
                end = i;
            }
        }
        return begin == -1 ? 0 : end - begin + 1;
    }

    // nlogn
    public int findUnsortedSubarray(int[] nums) {

        int[] newNums = new int[nums.length];
        for(int i = 0;i < nums.length ; i++){
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums);
        int begin = -1,end = -1;
        for(int i = 0;i < nums.length ; i++){
            if(nums[i] != newNums[i]){
                if(begin == -1){
                    begin = i;
                }
                end = i;
            }
        }
        if(begin == -1){
            return 0;
        }
        return end - begin + 1;
    }
}
