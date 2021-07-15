package com.h.test.leetcode;

import org.junit.Test;

import java.util.*;

public class MinAbsoluteSumDiff {

    @Test
    public void test(){
        int[] nums1 = {1,10,4,4,2};
        int[] nums2 = {9,3,5,1,7};
        System.out.println(minAbsoluteSumDiff(nums1,nums2));
    }

    private int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length];
        Set<Integer> minSet = new HashSet<>();
        int sumAbs = 0;
        for(int i = 0;i<nums1.length;i++){
            if(nums1[i] == nums2[i]){
                continue;
            }
            sumAbs += Math.abs(nums1[i] - nums2[i]);
            nums[i] = Math.abs(nums1[i] - nums2[i]);
        }
        System.out.println(sumAbs);
//        Arrays.sort(nums1);
        int maxVal = 0;
        for(int i = 0;i<nums2.length;i++){
            if(minSet.contains(nums2[i])){
                continue;
            }
           int minVal = getMinVal(nums1,nums2[i]);
            minSet.add(nums2[i]);

           if(nums[i] - minVal > maxVal){
                maxVal = nums[i] - minVal;
               System.out.println("i == " + i + "\t nums[i] = " + nums[i] + "\tminVal = " + minVal);
            }
        }
        return sumAbs - maxVal;
    }

    private Integer getMinVal(int[] nums1,int curNum){
        int res = 0;
        for(int i = 0;i<nums1.length-1;i++){
                res =  Math.abs(curNum - nums1[i]) < Math.abs(curNum - nums1[i + 1]) ? Math.abs(curNum - nums1[i]) : Math.abs(curNum - nums1[i + 1]);
        }
        return res;
    }
}
