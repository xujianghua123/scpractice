package com.h.test.leetcode;


import org.junit.Test;

/**
* @Description:
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
* @Author: xujianghua
* @Date: 2021/8/20 13:58
*/
public class ReverseStr_541 {

    @Test
    public void test(){
        System.out.println(reverseStr("abcdefghi",2));
    }

    public String reverseStr(String s, int k) {

        StringBuilder resStr = new StringBuilder();
        for(int i = 0;i< (s.length() % (2*k) == 0 ? s.length()/(2*k) : s.length()/(2*k) + 1); i++){
            if(i*2*k + k >= s.length()){
                resStr.append(new StringBuilder(s.substring(i*2*k)).reverse());
            }else if(i*2*k + 2*k >= s.length()){
                resStr.append(new StringBuilder(s.substring(i*2*k,i*2*k+k)).reverse())
                        .append(s.substring(i*2*k + k));
            }else{
                resStr.append(new StringBuilder(s.substring(i*2*k,i*2*k+k)).reverse())
                        .append(s.substring(i*2*k + k, i*2*k + 2*k));
            }
        }
        return resStr.toString();
    }
}
