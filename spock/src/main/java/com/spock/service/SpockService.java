package com.spock.service;

import org.junit.Test;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/17 11:30
 */
@Service
public class SpockService {

    public Integer test1(int num){
        if(num % 3 == 0){
            System.out.println(num + " % 3 == 0");
            return num;
        } else if(num % 3 == 1){
            System.out.println(num + " % 3 == 1");
            return num * 2;
        } else {
            System.out.println(num + " % 3 == 2");
            return num * 3;
        }
    }

    public void test2(int n){
        if(n > 0){
            System.out.println("+++++++++++++++");
        }else if(n == 0){
            System.out.println("---------------");
        }else {
            System.out.println("0000000000000");
        }
    }

    @Test
    public void test3(){
        BigDecimal a = new BigDecimal(1);
        for (int i = 0; i < 5; i++) {
            a = a.multiply(new BigDecimal(1.1));
            System.out.println(a);
        }
    }

}
