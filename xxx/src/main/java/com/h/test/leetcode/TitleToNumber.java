package com.h.test.leetcode;

import org.junit.Test;

public class TitleToNumber {

    @Test
    public void test(){
        System.out.println(this.titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {

        // 'A' = 65    'Z' =90

        char[] chars = columnTitle.toCharArray();
        int resNum = 0;
        for(int i = 0;i <chars.length;i++){
            resNum = resNum * 26 + chars[i] - 64;
        }
        return resNum;
    }
}
