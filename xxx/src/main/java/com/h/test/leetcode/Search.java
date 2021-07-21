package com.h.test.leetcode;


import org.junit.Test;

public class Search {

    public int search(int[] nums, int target) {

        int startIndex = 0,endIndex = 0;
        boolean startFlag = true,endFlag = true;
        for(int i = 0;i <= nums.length/2;i++){
            if(nums[i] == target && startFlag){
                startFlag = false;
                startIndex = i;
            }else if(nums[nums.length - i - 1] == target && endFlag){
                endFlag = false;
                endIndex = nums.length - i - 1;
            }
            if(nums[i+1] > target){
                endIndex = --i;
                break;
            }
        }



        return endIndex - startIndex;
    }

    @Test
    public void test(){

        int nums[] = {1};
        System.out.println(test(nums,1));
    }

    private int test(int[] nums, int target){
        if(nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)  return 0;
        for(int i = 0,n = 0;i<nums.length;i++){
            if(nums[i] == target) n++;
            if(i == nums.length - 1 || nums[i] > target) return n;
        }
        return 0;
    }
}
