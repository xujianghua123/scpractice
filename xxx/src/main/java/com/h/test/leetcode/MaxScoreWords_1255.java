package com.h.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxScoreWords_1255 {

    int maxScore = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lettersNums = new int[26];
        for (int i = 0; i < letters.length; i++) {   //设置一个保存字符出现次数的数组
            lettersNums[letters[i] - 'a']++;
        }

        int[] wordsScore = new int[words.length];
        for (int i = 0; i < words.length; i++) { //设置一个每个单词分数的数组。
            for (int j = 0; j < words[i].length(); j++) {
                wordsScore[i] += score[words[i].charAt(j) - 'a'];
            }
        }

        List<Integer> curWords = new ArrayList<>();

        dfs (0, lettersNums, words, wordsScore, curWords);

        return maxScore;
    }

    public void dfs(int start, int[] lettersNums, String[] words, int[] wordsScore, List<Integer> curWords) {
        countScore(wordsScore, curWords); // 对每个子集计算分数
        for (int i = start; i < words.length; i++) {
            if (isSatified(lettersNums, words[i])) { // 标准的求子集/排列 的问题， 字母数量不够的不计入考虑
                for (int j = 0; j < words[i].length(); j++) {
                    lettersNums[words[i].charAt(j) - 'a']--;
                }
                curWords.add(i);

                dfs (i + 1, lettersNums, words, wordsScore, curWords);

                for (int j = 0; j < words[i].length(); j++) {
                    lettersNums[words[i].charAt(j) - 'a']++;
                }
                curWords.remove(curWords.size() - 1);
            }
        }
    }

    public boolean isSatified(int[] lettersNums, String s){
        int[] temp = lettersNums.clone();            // 原数组还要用，就不在原数组上计算了，这里复制一个新数组。
        for (int i = 0; i < s.length(); i++) {
            if (--temp[s.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    public void countScore(int[] wordsScore, List<Integer> curWords){
        int sum = 0;
        for(Integer i : curWords) {
            sum = sum + wordsScore[i];
        }
        maxScore = Math.max(maxScore, sum);  // 保存最大分数到最终结果
    }

}
