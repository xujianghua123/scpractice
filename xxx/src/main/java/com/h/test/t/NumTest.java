package com.h.test.t;

import org.junit.Test;

public class NumTest {

    @Test
    public void test(){

        String num = "100";
        char[] chars = num.toCharArray();
        for(int i = num.length()-1;i>=0;i--){
            if(chars[i] > '3'){
                chars[i] = '3';
            }else if(chars[i] == '0'){
                if(i == 0){
                    continue;
                }
                zeroHandle(chars,i);
            }
        }

        System.out.println(chars.toString());
        String res = "";
        for(int i = 0;i<chars.length;i++){
            if(i==0 && chars[i] == '0'){
                continue;
            }
            res += chars[i];
        }
        System.out.println(res);
    }

    private void zeroHandle(char[] chars,int index){
        chars[index] = '3';
        while (--index >= 0 && chars[index] == '0'){
            chars[index] = '9';
        }
        chars[index]--;
    }

    @Test
    public void test2(){
        int n = 10000000;
        long l = System.currentTimeMillis();
        for(int i = 1;i<= 1000;i++){
            q1(n-i);
        }
//        System.out.println(q1(n));
        System.out.println("total time = " + (System.currentTimeMillis() - l) + " ms");
    }

    public int q1(int n){
        int res = 0;
        for(int i = 1;i<=n/2;i++){
            if(n%i == 0 ){
                if(n/i < i){
                    break;
                }
                res++;
            }
        }
        return res;
    }

}
