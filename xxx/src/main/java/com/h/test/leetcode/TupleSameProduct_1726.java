package com.h.test.leetcode;

import org.junit.Test;

import java.util.*;

/**
* @Description:
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 *
* @Author: xujianghua
* @Date: 2021/9/17 15:51
*/
public class TupleSameProduct_1726 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,4,5,10};
        System.out.println(tupleSameProduct(nums));
    }

    public int tupleSameProduct(int[] nums) {
        int res = 0;
        List<Integer> numList = new ArrayList<>();
        for(int a = 0; a < nums.length - 1; a++){
            for(int b = a + 1; b < nums.length;b++){
                numList.add(nums[a] * nums[b]);
            }
        }

        Collections.sort(numList);
        for(int i = 1,m = 1,cur = numList.get(0);i<numList.size();i++){
            if(numList.get(i) == cur){
                m++;
            }else if(m > 1 && numList.get(i) != cur){
                res += 8 * m * (m - 1) / 2;
                m = 1;
            }
            cur = numList.get(i);
        }
        return res;
    }
}
