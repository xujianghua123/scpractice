package com.spring.service;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/24 11:20
 */
@Import(Service2Impl.class)
@Service
public class Service1Impl implements BaseService {
    @Override
    public void action() {
        System.out.println("service11111111");
    }
}
