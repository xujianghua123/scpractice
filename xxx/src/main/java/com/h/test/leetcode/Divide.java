package com.h.test.leetcode;

import org.junit.Test;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide {

    @Test
    public void test(){
        System.out.println(divide(-2147483648,-1));
    }



    public int divide(int dividend, int divisor) {


        if(dividend == -2147483648 && divisor == -1){
            return 2147483647;
        }

        int d1 = Math.abs(dividend),d2 = Math.abs(divisor), n = 0;
        for(;d1 >= d2;n++){
            d1 = d1 - d2;
        }
        if(isNegative(dividend,divisor)){
            return -n;
        }
        return n;

    }

    private boolean isNegative(int dividend, int divisor){
        return (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
    }

}
