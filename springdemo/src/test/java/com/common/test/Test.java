package com.common.test;

import cn.hutool.json.JSONUtil;
import com.cloud.common.entities.Order;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/23 19:27
 */
public class Test {

    @org.junit.Test
    public void test01(){
        Long rr = 1L;

        long zz = 2l;

        if(rr instanceof Number){
            System.out.println("ffffffffff");
        }
    }

    @org.junit.Test
    public void test2(){
        List<Order> orders = Arrays.asList(new Order(1000L,"1000000"));
        System.out.println(orders instanceof Object);
        Object obj = orders;
        String s = JSONUtil.toJsonStr(obj);
        System.out.println(obj.toString());
        System.out.println(s);
        System.out.println(orders.toString());
    }
}
