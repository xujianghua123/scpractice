package com.h.test.leetcode;

import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
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
 */
public class MedianFinder {
    private Queue<Integer> minQueue;
    private Queue<Integer> maxQueue;
    public MedianFinder() {
        minQueue = new PriorityQueue(8, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        maxQueue = new PriorityQueue();
    }

    @Test
    public void test(){
        Random random = new Random();
        for(int i = 0;i<20;i++){
            int num = random.nextInt(100);
            addNum(num);
            System.out.println( "num = " + num + "\t median = " + findMedian());
        }
    }
    public void addNum(int num) {
        if(minQueue.isEmpty()){
            minQueue.add(num);
        }else if(minQueue.peek() > num){
            if(minQueue.size() > maxQueue.size()){
                maxQueue.add(minQueue.remove());
            }
            minQueue.add(num);
        }else if(maxQueue.isEmpty()){
            maxQueue.add(num);
        }else if(maxQueue.peek() < num){
            if(maxQueue.size() >= minQueue.size()){
                minQueue.add(maxQueue.remove());
            }
            maxQueue.add(num);
        }else {
            if(minQueue.size() > maxQueue.size()){
                maxQueue.add(num);
            }else {
                minQueue.add(num);
            }
        }
    }

    public double findMedian() {
        return minQueue.size() > maxQueue.size() ? minQueue.peek() : (minQueue.peek() + maxQueue.peek()) / 2d;
    }
}
