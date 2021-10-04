package com.h.test.leetcode;

public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
//        String[] s1 = s.split(" ");
//        return s1[s1.length - 1].length();
        int res = 0;
        for(int i = s.length() - 1;i >= 0;i--){
            if(s.charAt(i) != ' '){
                res++;
            }else if(res > 0 && s.charAt(i) == ' '){
                break;
            }
        }
        return res;
    }
}
