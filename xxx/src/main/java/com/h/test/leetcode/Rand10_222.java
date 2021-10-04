package com.h.test.leetcode;

import java.util.Random;

public class Rand10_222 {

    public int rand10() {
//        int[] rand = new int[50];
//        rand[2] = 1;rand[3] = 1;
//        rand[5] = 2;rand[7] = 2;
//        rand[1] = 3;rand[9] = 3;rand[16] = 3;rand[25] = 3;
//        rand[8] = 4;rand[10] = 4;
//        rand[36] = 5;rand[4] = 5;
//        rand[14] = 6;rand[15] = 6;
//        rand[18] = 7;rand[20] = 7;
//        rand[21] = 8;rand[24] = 8;
//        rand[28] = 9;rand[30] = 9;
//        rand[35] = 10;rand[42] = 10;

        int rand49 = 50;
        while (rand49 > 40){
           rand49 = (rand7() - 1) * 7 + rand7();
        }
        return rand49 % 10 + 1;
    }

    private int rand7(){
        return new Random().nextInt(7) + 1;
    }
}
