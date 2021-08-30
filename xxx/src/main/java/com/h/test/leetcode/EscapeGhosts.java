package com.h.test.leetcode;

import org.junit.Test;

public class EscapeGhosts {

    @Test
    public void test(){
        int[][] ghosts = new int[][]{{1,9},{2,-5},{3,8},{9,8},{-1,3}};
        int[] target = new int[]{8,-10};
        System.out.println(escapeGhosts(ghosts,target));
    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        int cur = Math.abs(target[0]) + Math.abs(target[1]);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i< ghosts.length;i++){
            min = Math.min(min,Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]));
            if(min <= cur){
                return false;
            }
        }
        return true;
    }

    private boolean escapeGhosts(int[][] ghosts, int[] target,int i,int j){
        int stepI = target[0] >= 0 ? 1 : -1;
        int stepJ = target[1] >= 0 ? 1 : -1;
        boolean escapeDown = escape(ghosts,new int[]{i+stepI,j});
        boolean escapeRight = escape(ghosts,new int[]{i,j+stepJ});
        if(Math.abs(i) > Math.abs(target[0]) && Math.abs(j) > Math.abs(target[1])){
            return false;
        }else if(Math.abs(i) == Math.abs(target[0]) && Math.abs(j) == Math.abs(target[1]) && escape(ghosts,new int[]{i,j})){
            return true;
        }
        if(escapeDown && escapeRight && Math.abs(target[0]) > Math.abs(i) && Math.abs(target[1]) > Math.abs(j)){
            return escapeGhosts(ghosts,target,i+stepI,j) || escapeGhosts(ghosts,target,i,j+stepJ);
        }else if(escapeDown && Math.abs(target[0]) > Math.abs(i)){
            return escapeGhosts(ghosts,target,i+stepI,j);
        }else if(escapeRight && Math.abs(target[1]) > Math.abs(j)){
            return escapeGhosts(ghosts,target,i,j+stepJ);
        }else {
            return false;
        }
    }

    private boolean escape(int[][] ghosts, int[] current){
        int cur = Math.abs(current[0]) + Math.abs(current[1]);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i< ghosts.length;i++){
            min = Math.min(min,Math.abs(current[0] - ghosts[i][0]) + Math.abs(current[1] - ghosts[i][1]));
            if(min <= cur){
                return false;
            }
        }
        return true;
    }

}
