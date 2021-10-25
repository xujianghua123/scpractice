package com.h.test.t;

import org.junit.Test;

public class SortTest {

    @Test
    public void quick(){
        int[] arr = new int[]{5,2,6,7,10,3,8,4,9,1};
        quick(arr,0,arr.length-1);
        for(int n: arr){
            System.out.print(n + "\t");
        }
    }

    private void quick(int[] arrs,int start,int end){
        int position = arrs[start];
        int left = start + 1,right = end;
        while (left <= right){
            if(arrs[left] <= position){
                int tem = arrs[left - 1];
                arrs[left - 1] = arrs[left];
                arrs[left] = tem;
                left++;
            }else{
                int tem = arrs[right];
                arrs[right] = arrs[left];
                arrs[left] = tem;
                right--;
            }
        }
        if(left > start+ 2){
            quick(arrs,start,left - 1);
        }
        if(left < end){
            quick(arrs,left ,end);
        }
    }

    private void hell(int[] arrs){
        int gap = arrs.length/2;
        while (gap > 0){
            for(int i = 0;i < arrs.length;i++){

                int cur = arrs[i];

            }
        }
    }
}
