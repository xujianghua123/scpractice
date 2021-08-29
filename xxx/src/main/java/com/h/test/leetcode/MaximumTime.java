package com.h.test.leetcode;

import org.junit.Test;

public class MaximumTime {

    @Test
    public void test(){
        System.out.println(maximumTime("0?:3?"));
    }

    public String maximumTime(String time) {

        char[] chars = time.toCharArray();
        if('?' == chars[0] && (chars[1] < '4' || '?' == chars[1])){
            chars[0] = '2';
        }else if('?' == chars[0] && chars[1] >= '4'){
            chars[0] = '1';
        }

        if('?' == chars[1] && chars[0] == '2'){
            chars[1] = '3';
        }else if('?' == chars[1] && chars[0] < '2'){
            chars[1] = '9';
        }

        if('?' == chars[3]){
            chars[3] = '5';
        }

        if('?' == chars[4]){
            chars[4] = '9';
        }


        return new String(chars);
    }
}
