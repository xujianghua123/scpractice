package com.h.test.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class MaxFrequency {

    @Test
    public void test(){
        int[] nums = {1,2,4,5,3,6,4,3,4};
        System.out.println(maxFrequency(nums,5));
    }


    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxVal = maxFrequency(nums, nums.length - 1, k, 1);
        return maxVal;
    }

    private int maxFrequency(int[] nums,int endIndex,int k,int maxVal){
        if(maxVal >= endIndex + 1){
            return maxVal;
        }
        int n = k;
        int curVal = nums[endIndex];
        for(int i = endIndex - 1,m = 1;i >= 0;i--){
            n = n - (curVal - nums[i]);
            if(n < 0){
                maxVal = maxVal >= m ? maxVal : m;
                while(endIndex > 0 && nums[endIndex] == nums[endIndex - 1]){
                    endIndex--;
                }
                return maxFrequency(nums, endIndex- 1, k, maxVal);
            }else if(i == 0){
                return ++m;
            }
            m++;
        }
        return 1;
    }
}
