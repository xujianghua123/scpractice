package com.h.test.sort;

import org.junit.Test;

public class Hell {
    private final int RANGE = 2;

    @Test
    public void test(){

        int[] arr = new int[]{2,7,10,3,8,4,9,1,6,5};
        sort(arr);
        for(int n: arr){
            System.out.print(n + "\t");
        }
    }

    private int[] sort(int[] arr){

        int gap = arr.length/RANGE;

        while (gap > 0){
            for(int i = gap; i < arr.length; i++){
               int cur = arr[i];
               int j = i - gap;
               while (j >= 0 && cur < arr[j]){
                   arr[j + gap] = arr[j];
                   j -= gap;
               }
                arr[j + gap] = cur;
            }
            gap = gap/RANGE;
        }

        return arr;
    }
}
