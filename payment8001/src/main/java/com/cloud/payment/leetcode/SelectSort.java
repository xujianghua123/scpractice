package com.cloud.payment.leetcode;

import org.junit.Test;

public class SelectSort {

    @Test
    public void test(){
        int[] arr = {6,3,9,2,6,1,7,8};
        arr = SelectSort.insertSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
    }

    /**
     * 选择
     * @param arr
     * @return
     */
    private static int[] selectSort(int[] arr){
        for(int i = 0;i< arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int tem = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tem;
        }
        return arr;
    }

    /**
     * 插入
     * @param arr
     * @return
     */
    private static int[] insertSort(int[] arr){

        for(int i = 1;i<arr.length;i++){
            int tem = arr[i];
            int index = i;
            for(int j = i - 1;j >= 0;j--){
                if(arr[j] <= tem){
                    break;
                }
                index = j;
                arr[j+1] = arr[j];
            }
            arr[index] = tem;
        }
        return arr;
    }


}
