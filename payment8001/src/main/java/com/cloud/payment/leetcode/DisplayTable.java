package com.cloud.payment.leetcode;

import org.junit.Test;

import java.util.*;

public class DisplayTable {

    @Test
    public void test(){
        String[][] arr = {{"CWdAM","10"," FlzD"},{" T","17","ok"},{"hai ","17","BlXft"},{"cTIg","15","MAvix"},{"jxK","9"," FlzD"},
                {"vqkCX","14","pLg"},{"qwqB","3","yPsk"},{"YR","15","zG"},{"ovex","11","pLg"},{"zHeWJ","14","TdmVi"},{"L ","9","Ey"},
                {"lyS","14","zG"},{"vasR","14","ok"},{"NtfZt","14","yPsk"},{"IN","5","xau"},{"GQ","5","bcr"}};
        List<List<String>> orders = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            orders.add(Arrays.asList(arr[i]));
        }
        this.displayTable(orders);
    }

    public List<List<String>> displayTable(List<List<String>> orders) {

        List<List<String>> resultList = new ArrayList<>();
        Map<String,Integer> foodMap = new HashMap<>();

        Set<Integer> tableSet = new HashSet<>();
        Set<String> foodSet = new HashSet<>();
        for(List<String> detail: orders){
            tableSet.add(Integer.valueOf(detail.get(1)));
            foodSet.add(detail.get(2));
        }
        List<Integer> tablesInt = new ArrayList<>(tableSet);
        List<String > foods = new ArrayList<>(foodSet);
        Collections.sort(tablesInt);
        Collections.sort(foods);

        for(int i = 0;i<foods.size();i++){
            foodMap.put(foods.get(i),i);
        }

        int[][] nums = new int[tablesInt.size()][foods.size()];
        List<String> foodKinds = new ArrayList<>();
        foodKinds.add("Table");
        foodKinds.addAll(foods);
        resultList.add(foodKinds);
        for(List<String> detail: orders){
            for(int i = 0;i<tablesInt.size();i++){
                if(Integer.valueOf(detail.get(1)).equals(tablesInt.get(i))){
                    nums[i][foodMap.get(detail.get(2))]++;
                }
            }

        }
        for(int i = 0;i<tablesInt.size();i++){
            List<String> foodNumbers = new ArrayList<>();
            foodNumbers.add(tablesInt.get(i).toString());
            for(int num:nums[i]){
                foodNumbers.add(String.valueOf(num));
            }
            resultList.add(foodNumbers);
        }

        return resultList;
    }
}
