package com.h.test.leetcode;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
* @Description:
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 *
* @Author: xujianghua
* @Date: 2021/8/9 10:08
*/
public class NthUglyNumber_264 {
    @Test
    public void test(){
        System.out.println(this.nthUglyNumber1(1690));
    }

    public int nthUglyNumber1(int n) {
        int[] primes = {2,3,5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumber(int n) {

        List<Long> uglyList = new ArrayList<>(Arrays.asList(1L));
        HashSet<Long> uglySet = new HashSet<>();
        uglySet.add(1L);
        uglyList = this.getUglyList(uglyList, uglySet,0, n);
        return uglyList.get(n - 1).intValue();
    }

    private List<Long> getUglyList(List<Long> uglyList,HashSet<Long> uglySet,int i,int n){

        Long ugly = uglyList.get(i);
        if(ugly*2 > Integer.MAX_VALUE || i >= n ){
            return uglyList;
        }
        if(!uglySet.contains(ugly*2)){
            uglyList.add(ugly*2);
            uglySet.add(ugly*2);
        }
        if(!uglySet.contains(ugly*3)){
            uglyList.add(ugly*3);
            uglySet.add(ugly*3);
        }
        if(!uglySet.contains(ugly*5)){
            uglyList.add(ugly*5);
            uglySet.add(ugly*5);
        }
        Collections.sort(uglyList);
        return getUglyList(uglyList,uglySet,++i,n);
    }

}
