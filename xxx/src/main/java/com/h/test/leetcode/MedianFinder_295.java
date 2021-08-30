package com.h.test.leetcode;

import org.junit.Test;

import java.util.*;

/**
* @Description:
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
* @Author: xujianghua
* @Date: 2021/8/27 13:41
*/
public class MedianFinder_295 {

    @Test
    public void test(){
        this.addNum(1);
        this.addNum(2);
        System.out.println(findMedian());
        this.addNum(3);
        System.out.println(findMedian());

    }


    private Map<Integer,Integer> numMap;
    private int size;
    private boolean flag = true;
    private double curMid = 0.00d;
    /** initialize your data structure here. */
    public MedianFinder_295() {
        numMap = new HashMap<>();
        size = 0;
    }

    public void addNum(int num) {
        if(numMap.containsKey(num)){
            Integer n = numMap.get(num) + 1;
            numMap.put(num,n);
        }
        size ++;
        flag = false;
    }

    public double findMedian() {
        if(flag){
            return curMid;
        }

        for(Integer i :numMap.values()){

        }

        return  size;
    }
}
