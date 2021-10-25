package com.h.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {

    @Test
    public void test(){
        int[] nums = {3,2,3};
        System.out.println(this.majorityElement1(nums));
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

    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> resList = new ArrayList();
        Arrays.sort(nums);
        int n = nums.length/3;
        int m = 0,cur = nums[0];
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == cur){
                m++;
            } else{
                if(m > n){
                    resList.add(cur);
                }
                m = 1;
                cur = nums[i];
            }
            if(i == nums.length -1 && m > n){
                resList.add(cur);
            }
        }
        return resList;
    }
}
