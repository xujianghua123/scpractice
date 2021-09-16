package com.h.test.leetcode;

import org.junit.Test;

public class FindPeakElement_162 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,4,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int peakElement = findPeakElement(nums, 0, nums.length - 1);
        return peakElement;
    }

    private int findPeakElement(int[] nums,int start,int end){
        if(start == end){
            return start;
        }
        int mid = (start+end)/2;
        if((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length-1 || nums[mid + 1] < nums[mid])){
            return mid;
        }
        if(mid > 0 && nums[mid - 1] > nums[mid]){
            return findPeakElement(nums,start,mid-1);
        }else if(mid < nums.length-1 && nums[mid + 1] > nums[mid]){
            return findPeakElement(nums,mid+1,end);
        }
        return start;
    }
}
