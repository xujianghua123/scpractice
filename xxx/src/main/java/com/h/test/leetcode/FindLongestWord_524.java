package com.h.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLongestWord_524 {

    @Test
    public void test(){
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        String s = "abpcplea";
        System.out.println(findLongestWord(s,dictionary));
    }

    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        String res = "";
        for(int i = 0;i < dictionary.size();i++){
            if(res != "" && res.length() >  dictionary.get(i).length()){
                break;
            }
            if(containsWord(s,dictionary.get(i))){
                if(res != ""){
                    res = dictionary.get(i).compareToIgnoreCase(res) > 0 ? res : dictionary.get(i);
                }else {
                    res = dictionary.get(i);
                }
            }
        }

        return res;
    }

    private boolean containsWord(String s,String word){
        int j = 0;
        for(int i = 0;i < s.length() && j < word.length();i++){
            if(s.charAt(i) == word.charAt(j)){
                j++;
            }
        }
        return j == word.length();
    }
}
