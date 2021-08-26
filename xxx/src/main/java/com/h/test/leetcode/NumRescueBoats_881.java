package com.h.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
* @Description:
 *
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
* @Author: xujianghua
* @Date: 2021/8/26 11:00
*/
public class NumRescueBoats_881 {

    @Test
    public void test(){

        int[] people = new int[]{2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
        System.out.println(numRescueBoats(people,50));
    }

    /**
     * 每艘船最多载两人
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0,r = people.length-1,m = 0;
        for(;l<=r;r--,m++){
            if (people[r] + people[l] <= limit && l<r){
                l++;
            }
        }
        return m;
    }

    /**
     * 仅考虑重量，不考虑每艘船承载人数
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0,r = people.length-1,m = 0;
        while (l<=r){
            int sum = people[r] + people[l];
            while (sum <= limit && l<r){
                l++;
                sum += people[l];
            }
            r--;
            m++;
        }
        return m;
    }
}
