package com.common.test;

import com.spring.controller.BaseController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/24 13:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectTest {

    @Resource
    private BaseController baseController;

    @Test
    public void test(){
        baseController.test();
    }
}
