package com.spring.controller;

import com.cloud.common.entities.Order;
import com.cloud.common.entities.User;
import com.spring.service.OrderService;
import com.spring.service.Service2Impl;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/22 11:18
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private Service2Impl service2;

    public void queryUser(){
        System.out.println("********** query User controller ***********");
        User user = userService.getUser(1L,"abc");
        System.out.println(user);
    }

    public void addUser(){
        System.out.println("********** add User controller begin ***********");
        userService.addUser();
        System.out.println("********** add User controller end ***********");
    }

    public void testImport(){
        service2.action();
    }
}
