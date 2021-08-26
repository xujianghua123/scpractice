package com.h.test.leetcode;

import org.junit.Test;

public class GetMaximumGenerated_1646 {

    @Test
    public void test(){
        System.out.println(getMaximumGenerated(100));
    }

    public int getMaximumGenerated(int n) {

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int maxVal = 0;
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2;i <= n;i++){
            if(i%2 == 0){
                nums[i] = nums[i/2];
            }else {
                nums[i] = nums[i/2] + nums[i/2 + 1];
            }
            maxVal = Math.max(maxVal,nums[i]);
        }
        return maxVal;
    }
}
