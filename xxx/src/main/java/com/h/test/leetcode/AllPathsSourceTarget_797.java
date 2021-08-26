package com.h.test.leetcode;

import org.junit.Test;

import java.util.*;

public class AllPathsSourceTarget_797 {

    @Test
    public void test(){

        int[][] graph = new int[][]{{2},{3},{1},{}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> resList = new ArrayList<>();
        List<List<Integer>> midList = new ArrayList<>();
        midList.add(Arrays.asList(0));
        for(int i = 0 ;i<graph.length;i++){
            if(graph[i].length == 0){
                continue;
            }
           for(int k = 0;k<midList.size();k++){
               List<Integer> l = midList.get(k);

               if(l.get(l.size()-1) != i){
                   continue;
               }

               for(int j = 0;j<graph[i].length;j++){
                   List<Integer> mid = new ArrayList<>();
                   mid.addAll(l);
                   mid.add(graph[i][j]);
                   if(graph[i][j] == graph.length-1){
                       resList.add(mid);
                   }else{
                       midList.add(mid);
                   }
               }
           }

        }
        return resList;
    }

}
