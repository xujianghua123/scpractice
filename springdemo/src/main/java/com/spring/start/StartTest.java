package com.spring.start;

import com.spring.config.Appconfig;
import com.spring.controller.BaseController;
import com.spring.controller.OrderController;
import com.spring.controller.UserController;
import com.spring.service.Service2Impl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
//        OrderController orderController = (OrderController)context.getBean("orderController");
//        orderController.queryOrder();

//
        UserController userController = (UserController)context.getBean("userController");
        userController.testImport();


//        Service2Impl service2 = context.getBean(Service2Impl.class);
//        service2.action();

        System.out.println("**********************************************************************************");
//        userController.addUser();
    }
}
