package com.h.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class IsCovered_1893 {

    @Test
    public void test(){
        int[][] ranges = {{13,43},{19,20},{32,38},{26,33},{3,38},{16,31},{26,48},{27,43},{12,24}};
        System.out.println(isCovered(ranges,36,45));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {

        boolean isStart = false;
        Arrays.sort(ranges,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0;i< o1.length;i++){
                    if(o1[i] > o2[i]){
                        return 1;
                    }else if(o1[i] < o2[i]){
                        return -1;
                    }
                }
                return 0;
            }
        });
        for(int i = 0;i< ranges.length;i++){

            if(i > 0 && ranges[i-1][ranges[i].length - 1] >= ranges[i][ranges[i].length - 1]){
                ranges[i] = ranges[i-1];
                continue;
            }

            if(isStart && i > 0 && ranges[i][0]- ranges[i-1][ranges[i].length - 1] > 1){
                return false;
            }

            if(ranges[i][ranges[i].length - 1] < left){
                continue;
            }else if(ranges[i][0] > left && !isStart){
                return false;
            }else if(ranges[i][ranges[i].length - 1] >= left && ranges[i][0] <= left){
                isStart = true;
            }

            if(ranges[i][ranges[i].length - 1] >= right && ranges[i][0] <= right && isStart){
                return true;
            }
        }
        return false;
    }
}
