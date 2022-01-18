package com.spring.controller;

import com.cloud.common.entities.Order;
import com.spring.service.OrderService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/22 11:18
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    public void queryOrder(){
        System.out.println("********** query order controller ***********");
        Order order = orderService.getOrder();
        System.out.println(order);
    }

    public void addOrder(){
        System.out.println("********** add order controller begin ***********");
        orderService.addOrder();
        System.out.println("********** add order controller end ***********");
    }
}
