package com.cloud.payment.leetcode;

import org.junit.Test;

public class NumSubarraysWithSum {

    @Test
    public void test(){

        int[] nums = {1,0,1,0,1};
        System.out.println(this.numSubarraysWithSum(nums,2));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        int num = 0;
        for(int i = 0;i < nums.length;i++){
            int sum = nums[i];
            if(sum == goal){
                num++;
            }
            for(int j = i + 1;j<nums.length;j++){
                sum += nums[j];
                if(sum == goal){
                    num++;
                }else if(sum > goal){
                    break;
                }
            }
        }
        return num;
    }
}
