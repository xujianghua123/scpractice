package com.h.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 */
public class FindWords_212 {

    @Test
    public void test(){
        char[][] board = new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = new String[]{"eaafgdcba","eaabcdgfa"};
        List<String> resWords = this.findWords(board, words);
        for(String word:resWords){
            System.out.println(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> resWords = new ArrayList<>();
        for(String word:words){
            boolean isExsit = false;
            char[] chars = word.toCharArray();
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[i].length;j++){
                    if(chars[0] == board[i][j]){
                        boolean[][] isUsed = new boolean[board.length][board[0].length];
                        if(findWords(board,isUsed,chars,0,i,j)){
                            isExsit = true;
                            break;
                        }
                    }
                }
                if(isExsit){
                    break;
                }
            }
            if(isExsit){
                resWords.add(word);
            }
        }
        return resWords;
    }

    private boolean findWords(char[][] board,boolean[][] isUsed,char[] chars,int index,int i,int j){
        if(chars[index] == board[i][j]){
            if(index == chars.length-1){
                return true;
            }
            isUsed[i][j] = true;
        }else {
            return false;
        }
        boolean f1 = false,f2=false,f3=false,f4=false;
        if(i>0 && !isUsed[i-1][j]){
            f1 = findWords(board,isUsed,chars,index+1,i-1,j);
        }
        if(i<board.length-1 && !isUsed[i+1][j]){
            f2 = findWords(board,isUsed,chars,index+1,i+1,j);
        }
        if(j>0 && !isUsed[i][j-1]){
            f3 = findWords(board,isUsed,chars,index+1,i,j-1);
        }
        if(j<board[0].length-1 && !isUsed[i][j+1]){
            f4 = findWords(board,isUsed,chars,index+1,i,j+1);
        }
        if(!f1 && !f2 && !f3 && !f4){
            isUsed[i][j] = false;
            return false;
        }
        return true;
    }
}
