package com.cloud.consul.controller;

import com.cloud.consul.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class HystrixController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping(value = "/payment/hystrix/paymentHystrix/ok")
    public String ok() {
        log.info("com.cloud.consul.controller.ConsulController.ok");
        return hystrixService.normal();
    }

    @RequestMapping(value = "/payment/hystrix/paymentHystrix/ex")
    public String ex() {
        log.info("com.cloud.consul.controller.ConsulController.ex");
        return hystrixService.unNormal();
    }
}
