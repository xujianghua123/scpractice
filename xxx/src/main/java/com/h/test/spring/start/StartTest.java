package com.h.test.spring.start;

import com.h.test.spring.config.Appconfig;
import com.h.test.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        UserService userservice = (UserService)context.getBean("userService");
        userservice.sayHello();
    }
}
