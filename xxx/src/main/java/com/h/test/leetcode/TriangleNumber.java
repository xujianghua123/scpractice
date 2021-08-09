package com.h.test.leetcode;

import java.util.Arrays;

public class TriangleNumber {

    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length - 2;i++){
            for(int j = i + 1;j < nums.length - 1;j++){
                for(int m = j + 1;m< nums.length;m++){
                    if(nums[m] >= nums[i] + nums[j]){
                        break;
                    }
                    sum++;
                }
            }
        }
        return sum;
    }

    public int triangleNumber1(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length - 2;i++){
            for(int j = i + 1;j < nums.length - 1;j++){
                for(int m = nums.length - 1;m > j;m--){
                    if(nums[m] < nums[i] + nums[j]){
                        sum += m - 1;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
