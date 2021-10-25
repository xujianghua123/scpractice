package com.h.test.sort;

import org.junit.Test;

public class Quick {

    @Test
    public void test(){
        int[] arr = new int[]{5,2,6,7,10,3,8,4,9,1};
        sort(arr);
        for(int n: arr){
            System.out.print(n + "\t");
        }
    }

    private void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    /**
     * 单边扫描
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    private void sort(int[] array,int startIndex,int endIndex){
        int left = startIndex,right = endIndex;
        int p = array[left];
        while (left < right){
            if(array[left+1]<= p){
                int temp = array[left+1];
                array[left+1] = p;
                array[left] = temp;
                left++;
            }else {
                int temp = array[right];
                array[right] = array[left+1];
                array[left+1] = temp;
                right--;
            }
        }

        if(left > startIndex + 1){
            sort(array,startIndex,left-1);
        }
        if(left < endIndex -1){
            sort(array,left+1,endIndex);
        }
    }
}
