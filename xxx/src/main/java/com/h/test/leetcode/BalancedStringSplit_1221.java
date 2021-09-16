package com.h.test.leetcode;

public class BalancedStringSplit_1221 {

    public int balancedStringSplit(String s) {
        int n = 0,m = 0;
        for(char ch:s.toCharArray()){
            if(ch == 'L'){
                if(--n == 0){
                    m++;
                }
            }else{
                if(++n == 0){
                    m++;
                }
            }
        }
        return m;
    }
}
