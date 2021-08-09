package com.h.test.leetcode;

/**
* @Description:
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
* @Author: xujianghua
* @Date: 2021/8/9 9:24
*/
public class IsUgly_263 {

    public boolean isUgly(int n) {

        if(n == 1){
            return true;
        }else if(n < 1){
            return false;
        }

        if(n % 2 == 0){
            return isUgly(n/2);
        }else if(n % 3 == 0){
            return isUgly(n/3);
        }else if(n % 5 == 0){
            return isUgly(n/5);
        }
        return false;
    }
}
