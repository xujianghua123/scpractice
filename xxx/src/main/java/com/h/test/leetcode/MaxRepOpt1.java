package com.h.test.leetcode;

import org.junit.Test;

public class MaxRepOpt1 {

    @Test
    public void test(){

        String text = "abaabaaabaaaabaaaaa";
        System.out.println(maxRepOpt1(text));
    }


    public int maxRepOpt1(String text) {

        char[] chars = text.toCharArray();
        int[] arr = new int[26];
        for(int i = 0;i<chars.length;i++){
            arr[chars[i] - 97]++;
        }
        int maxPrp = 1,curNum = 1,allowTime = 0;
        char curChar = chars[0],preChar = chars[0];
        for(int i = 1;i<chars.length;i++){

            if(curChar == chars[i]){
                curNum++;
            }else if(curChar != chars[i] && allowTime == 0){
                if(i == chars.length -1 || curChar != chars[i+1]){
                    allowTime++;
                }
                allowTime++;
                preChar = chars[i];
            }else{
                if(curNum > maxPrp){
                    maxPrp = curNum;
                    System.out.println("maxChar:" + curChar);
                }
                allowTime = 0;
                curNum = 1;
                curChar = chars[i];
                if(preChar == chars[i]){
                    curNum++;
                }

            }
        }
        return curNum > maxPrp ? curNum : maxPrp;
    }

    public int maxRepOpt2(String text) {

        int[][] arrs = new int[26][2];
        int[] arr = new int[26];
        char[] chars = text.toCharArray();
        for(int i = 0;i<chars.length;i++){
            arr[chars[i] - 97]++;
        }

        int maxPrp = 1,curNum = 1,allowTime = 0;
        char curChar = chars[0],preChar = chars[0];
        for(int i = 1;i<chars.length;i++){
            if(curChar == chars[i]){
                curNum++;
            }else if(curChar != chars[i] && ((i!= (chars.length-1) && curChar != chars[i+1]) || i== (chars.length-1))){
                if(curNum < arr[curChar - 97]){
                    curNum++;
                }
                if(curNum > maxPrp){
                    maxPrp = curNum;
                }
            }else if(curChar != chars[i] && allowTime == 0){

            }
        }
        return 1;
    }
}
