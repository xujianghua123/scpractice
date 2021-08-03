package com.h.test.leetcode;

import java.util.*;

public class MinOperations {

    public int minOperations(int[] target, int[] arr) {

        Map<Integer,Integer> targetMap = new HashMap<>();
        for(int i = 0; i<target.length;i++){
            targetMap.put(target[i],i);
        }

        List<Integer> arrList = new ArrayList<>();
        for(int a:arr){
            if(targetMap.containsKey(a)){
                arrList.add(a);
            }
        }

        int maxSerial = maxSerial(targetMap, arrList);
        return target.length - maxSerial;
    }

    public int maxSerial(Map<Integer,Integer> targetMap,List<Integer> arrList){
        int maxSerial = 0;
        for(int i = 0;i<arrList.size();i++){
            if(arrList.size() - i < maxSerial){
                break;
            }
            for(int j = i;j<arrList.size();j++){

            }
        }

        return 0;
    }
}
