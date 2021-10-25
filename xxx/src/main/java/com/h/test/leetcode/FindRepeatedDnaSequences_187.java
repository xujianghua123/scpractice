package com.h.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

/**
* @Description:
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
* @Author: xujianghua
* @Date: 2021/10/8 10:08
*/
public class FindRepeatedDnaSequences_187 {

    @Test
    public void test(){

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> repeatedDnaSequences = findRepeatedDnaSequences2(s);
        for(String str:repeatedDnaSequences){
            System.out.println(str);
        }

    }

    public List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> totStrSet = new HashSet<>();
        HashSet<String> resStrSet = new HashSet<>();
        for(int i = 0;i < s.length() - 9;i++){
            String str = s.substring(i, i + 10);
            if(totStrSet.contains(str)){
                resStrSet.add(str);
            }
            totStrSet.add(str);
        }
        return new ArrayList<>(resStrSet);
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        HashSet<String> resStrSet = new HashSet<>();
        for(int i = 0;i < s.length() - 10;i++){
            String substring = s.substring(i + 1);
            String str = s.substring(i, i + 10);
            boolean matches = Pattern.compile(str).matcher(substring).find();
            if(matches){
                resStrSet.add(str);
            }
        }
        return new ArrayList<>(resStrSet);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> resStrSet = new HashSet<>();
        char[] chars = s.toCharArray();
        for(int i = 0;i < s.length() - 10;i++){
            if(resStrSet.contains(s.substring(i,i+10))) continue;

            for(int j = i + 1;j < s.length() - 9;j++){
                if(sameNum(chars,i,j)){
                    resStrSet.add(s.substring(j,j+10));
                    break;
                }
            }
        }
        return new ArrayList<>(resStrSet);
    }

    private boolean sameNum(char[] chars,int i,int j){

        for(int k = 0;k < 10;k++){
            if(chars[i + k] != chars[j + k]){
                return false;
            }
        }
        return true;
    }
}
