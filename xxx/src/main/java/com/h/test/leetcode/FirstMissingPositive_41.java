package com.h.test.leetcode;

import org.junit.Test;

/**
* @Description:
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
* @Author: xujianghua
* @Date: 2021/8/10 19:11
*/
public class FirstMissingPositive_41 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,0};
        System.out.println(firstMissingPositive1(nums));
    }

    public int firstMissingPositive(int[] nums) {

        boolean[] isContains = new boolean[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0 && nums[i] <= nums.length){
                isContains[nums[i]-1] = Boolean.TRUE;
            }
        }

        for(int i = 0;i<=nums.length;i++){
            if(!isContains[i]){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public int firstMissingPositive1(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n+1;
    }

}
