package com.spring.controller;

import com.spring.service.BaseService;
import com.spring.service.Service2Impl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/24 11:22
 */
@Controller
public class BaseController {

    @Resource
    private Service2Impl baseService;

    public void test(){
        baseService.action();
    }
}
