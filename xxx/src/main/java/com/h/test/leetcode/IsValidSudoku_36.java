package com.h.test.leetcode;

import org.junit.Test;

/**
* @Description:
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
* @Author: xujianghua
* @Date: 2021/9/17 9:12
*/
public class IsValidSudoku_36 {

    @Test
    public void test(){
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        return oneCheck(board) && towCheck(board) && threeCheck(board);
    }

    private boolean oneCheck(char[][] board){
        for(int i = 0;i < 9;i++){
            boolean[] isExist = new boolean[10];
            for(int j = 0;j< 9;j++){
                if(board[i][j] >= '0' && board[i][j] <= '9'){
                    if(isExist[board[i][j] - '0']){
                        return false;
                    }
                    isExist[board[i][j] - '0'] = true;
                }
            }
        }
        return true;
    }

    private boolean towCheck(char[][] board){
        for(int i = 0;i<board[0].length;i++){
            boolean[] isExist = new boolean[10];
            for(int j = 0;j<board.length;j++){
                if(board[j][i] >= '0' && board[j][i] <= '9'){
                    if(isExist[board[j][i] - '0']){
                        return false;
                    }
                    isExist[board[j][i] - '0'] = true;
                }
            }
        }
        return true;
    }

    private boolean threeCheck(char[][] board){
        for(int i = 0;i<board.length/3;i++){
            for(int j = 0;j<board[0].length/3;j++){
                if(!threeCheck(board,i*3,j*3)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean threeCheck(char[][] board,int m,int n){
        boolean[] isExist = new boolean[10];
        for(int i = m;i<m+3;i++){
            for(int j = n;j<n+3;j++){
                if(board[i][j] >= '0' && board[i][j] <= '9'){
                    if(isExist[board[i][j] - '0']){
                        return false;
                    }
                    isExist[board[i][j] - '0'] = true;
                }
            }
        }
        return true;
    }

}
