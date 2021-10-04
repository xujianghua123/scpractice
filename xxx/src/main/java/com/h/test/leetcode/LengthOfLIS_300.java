package com.h.test.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class LengthOfLIS_300 {
    @Test
    public void test(){
        int[] nums = {2,2,2,2,2};
//        System.out.println(lengthOfLIS(nums));
        System.out.println(findNumberOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        for(int i = 1;i < nums.length; i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int maxVal = dp[0];
        for(int val:dp){
            maxVal = Math.max(maxVal,val);
        }
        return maxVal+1;
    }

    public int findNumberOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int[] numbers = new int[nums.length];
        for(int i = 0;i< numbers.length;i++){
            dp[i] = 1;
            numbers[i] = 1;
        }
        for(int i = 1;i < nums.length; i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j] && dp[i] <= dp[j] + 1){
                    if(dp[i] < dp[j] + 1){
                        numbers[i] = numbers[j];
                    }else if(dp[i] == dp[j] + 1){
                        numbers[i] += numbers[j];
                    }
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int res = 0;
        int maxVal = dp[0];
        for(int val:dp){
            maxVal = Math.max(maxVal,val);
        }
        for(int i = 0;i<numbers.length;i++){
            if(maxVal == dp[i]){
                res += numbers[i];
            }
        }
        return res;
    }
}
