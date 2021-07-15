package com.h.test.leetcode;

import org.junit.Test;

public class MajorityElement {

    @Test
    public void test(){
        int[] nums = {1,2,5,9,5,9,5,5,5};
        System.out.println(this.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {

        int count = 1;
        int majority = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(count == 0){
                majority = nums[i];
                count++;
            }else if(majority == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for(int i = 0;i<nums.length;i++){
            if(majority == nums[i]){
                count++;
            }
        }
        return count > (nums.length/2) ? majority : -1;
    }
}
