package com.h.test.sort;

public class Test {

    @org.junit.Test
    public void quick(){
        int[] arrs = new int[]{3,7,8,2,10,6,1,9,5,4};
//        int[] arrs = new int[]{3,2,1,5,4};
        quick(arrs,0,arrs.length-1);
        for (int i = 0; i < arrs.length ; i++) {
            System.out.print(arrs[i] + "\t");
        }
    }

    private void quick(int[] arrs,int startIndex,int endIndex){


    }
}
