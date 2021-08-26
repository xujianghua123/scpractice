package com.h.test.leetcode;

import org.junit.Test;

/**
* @Description:
 *
如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

子数组 是数组中的一个连续序列。

* @Author: xujianghua
* @Date: 2021/8/10 9:16
*/
public class NumberOfArithmeticSlices_413 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,4,5,4,3,2,0,-2,-4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int beginIndex = 0,deviation = nums[1] - nums[0],resNum = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] - nums[i-1] != deviation){
                if(i-beginIndex > 1){
                    resNum += (i-beginIndex-1) * (i-beginIndex-2)/2;
                }
                beginIndex = i - 1;
                deviation = nums[i] - nums[i-1];
            }
        }
        // 处理最后一拨儿
        if(nums.length-beginIndex > 2){
            resNum += (nums.length-beginIndex-1) * (nums.length-beginIndex-2)/2;
        }
        return resNum;
    }
}
