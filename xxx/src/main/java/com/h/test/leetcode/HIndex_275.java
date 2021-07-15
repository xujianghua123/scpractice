package com.h.test.leetcode;

import org.junit.Test;

public class HIndex_275 {

    @Test
    public void test(){
        int[] citations = {100};
        System.out.println(hIndex(citations));
    }

    public int hIndex(int[] citations) {
        int n = 0;
        for(int i = 0;i< citations.length;i++){
            if((citations[i] + i) >= citations.length){
                n ++;
            }else if(n >= (citations.length - i)){
                break;
            }
        }
        return n;
    }
}
