package com.h.test.leetcode;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description:
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
* @Author: xujianghua
* @Date: 2021/8/13 14:07
*/
public class CountDigitOne_233 {

    @Test
    public void test() throws ParseException {
        long l = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2021-08-20");
        Date curDate = new Date();

        System.out.println(parse.compareTo(curDate));

//        System.out.println(countDigitOne(1000000000));
//        System.out.println(System.currentTimeMillis() - l);
    }

    public int countDigitOne(int n) {

        int res = 0;
        char[] chars = String.valueOf(n).toCharArray();
        for(int i = chars.length - 1;i>=0;i--){

        }
        return res;
    }
}
