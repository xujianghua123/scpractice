package com.cloud.payment.leetcode;

import org.junit.Test;

import java.util.*;

public class CountPairs {

    @Test
    public void test(){
        long startTime = System.currentTimeMillis();
        int[] deliciousness = {2,2,2,2,2};
        System.out.println(this.countPairs1(deliciousness));
        System.out.println(System.currentTimeMillis() - startTime + "ms");
    }

    public int countPairs(int[] deliciousness) {

        if(deliciousness.length < 2){
            return 0;
        }
        Arrays.sort(deliciousness);
        Set<Integer> dcSet = new HashSet<>();
        int power = 1;
        int maxDc = deliciousness[deliciousness.length-1] + deliciousness[deliciousness.length-2];
        while (power <= maxDc){
            dcSet.add(power);
            power = power << 1;
        }

        int kinds = 0;
        int curNum = 0;
        for(int i = 0;i<deliciousness.length - 1;i++){

            if(i > 0 && deliciousness[i] == deliciousness[i-1]){

                if(curNum > 0){
                    kinds += curNum;
                    if(dcSet.contains(deliciousness[i] + deliciousness[i-1])){
                        curNum --;
                        kinds--;
                    }
                }
                continue;
            }
            curNum = 0;
            for(int j = i+1;j< deliciousness.length;j++){
                if(dcSet.contains(deliciousness[i] + deliciousness[j])){
                    kinds++;
                    curNum++;
                }
            }
        }
        return kinds;
    }

    @Test
    public void test2(){
        long startTime = System.currentTimeMillis();
        int[] deliciousness = new int[100000];
        for(int i = 0;i<100000;i++){
            deliciousness[i] = 32;
        }
        System.out.println(this.countPairs1(deliciousness));
        System.out.println(System.currentTimeMillis() - startTime + "ms");

    }

    public int countPairs1(int[] deliciousness) {

        if(deliciousness.length < 2){
            return 0;
        }
        Arrays.sort(deliciousness);
        Map<Integer, Integer> decMap = new HashMap<>();
        int n = 1;
        for(int i = 0;i < deliciousness.length; i++){
            if(i == (deliciousness.length - 1) || deliciousness[i] != deliciousness[i+1]){
                decMap.put(deliciousness[i],n);
                n = 0;
            }
            n++;
        }
        int kinds = 0;
        int power = 1;
        int maxDc = deliciousness[deliciousness.length-1] + deliciousness[deliciousness.length-2];
        while (power <= maxDc){
            if(power == 1 && decMap.containsKey(0) && decMap.containsKey(1)){
                kinds += decMap.get(0) * decMap.get(1);
                power = power << 1;
                continue;
            }
            for(int i = 0;i <= power/2;i++){
                if(decMap.containsKey(i) && decMap.containsKey(power-i) && i == (power-i)){
                    kinds += decMap.get(i) * (decMap.get(i) - 1)/2;
                }else if(decMap.containsKey(i) && decMap.containsKey(power-i) && i < (power-i)){
                    kinds += decMap.get(i) * decMap.get(power-i);
                }
            }
            power = power << 1;
        }
        return kinds;
    }

}
