package com.h.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class RestoreArray_1743 {

    @Test
    public void test() {
        int[][] adjacentPairs = {{4,-10},{-1,3},{4,-3},{-3,3}};
        this.restoreArray(adjacentPairs);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs.length == 1){
            return adjacentPairs[0];
        }

        HashSet<Integer> numSet = new HashSet<>();
        HashSet<int[]> objArrSet = new HashSet<>();
        for(int[] arr:adjacentPairs){
            objArrSet.add(arr);
            if (numSet.contains(arr[0])) {
                numSet.remove(arr[0]);
            } else {
                numSet.add(arr[0]);
            }
            if(numSet.contains(arr[1])){
                numSet.remove(arr[1]);
            }else{
                numSet.add(arr[1]);
            }
        }
        int[] nums = new int[adjacentPairs.length + 1];
        Object[] objArray = numSet.toArray();

        nums[0] = Math.min((Integer) objArray[0],(Integer) objArray[1]);
        for(int i = 0;i < adjacentPairs.length;i++){

            for(int[] arr:objArrSet){
                if(arr[0] == nums[i] || arr[1] == nums[i]){
                    nums[i+1] = arr[0] == nums[i] ? arr[1] : arr[0];
                    objArrSet.remove(arr);
                    break;
                }
            }
        }
        return nums;
    }
}
