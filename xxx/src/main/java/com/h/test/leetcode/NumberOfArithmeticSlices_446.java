package com.h.test.leetcode;

import org.junit.Test;

import java.util.*;

/**
* @Description:
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 *
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 *
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 *
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 *
* @Author: xujianghua
* @Date: 2021/8/11 10:29
*/
public class NumberOfArithmeticSlices_446 {

    @Test
    public void test(){
            int[] nums = new int[]{1,2,3,4,5,4,3,2,1};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices1(int[] nums) {

        Set<Long> devSet = new HashSet<>();
        List<List<Long>> resList = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i;j< nums.length;j++){
                devSet.add(1L + nums[j] - nums[i]);
            }
        }
        Iterator<Long> devIterator = devSet.iterator();
        while (devIterator.hasNext()){
            Long dev = devIterator.next();
            for(int i=0;i<nums.length-2;i++){
                List<Long> devList = new ArrayList<>();
                int curNum = nums[i];
                devList.add(1L + curNum);
                for(int j = i;j<nums.length;j++){
                    if(nums[j] == curNum + dev){
                        devList.add(curNum + dev);
                        curNum += dev;
                    }
                }
                if(devList.size() > 2){
                    resList.add(devList);
                }
            }
        }

        int res = 0;
        for(List<Long> list:resList){
            res += list.size() - 2;
        }
        return res;
    }
}
