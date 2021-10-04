package com.h.test.leetcode;

import org.junit.Test;

public class MinDistance_583 {

    @Test
    public void test(){
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1,word2));
    }

    public int minDistance(String word1, String word2) {

        int[] pub = new int[word1.length()];
        boolean[] pubBol = new boolean[word2.length()];

        for(int i = 0;i < word1.length();i++){
            for(int j = 0;j < word2.length();j++){
                if(word1.charAt(i) == word2.charAt(j) && !pubBol[j]){
                    pub[i] = j + 1;
                    pubBol[j] = true;
                    break;
                }
            }
        }

        int[] dp = new int[word1.length()];
        for(int i = 0;i< word1.length();i++){
            if(pub[i] > 0){
                dp[i] = 1;
            }
        }

        for(int i = 1;i < word1.length();i++){
            if(pub[i] == 0){
                continue;
            }
            for(int j = 0;j < i;j++){
                if(pub[j] == 0){
                    continue;
                }
                if(pub[i] > pub[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0;i < dp.length;i++){
            max = Math.max(dp[i],max);
        }
        return word1.length() + word2.length() - 2*max ;
    }
}
