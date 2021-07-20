package com.cloud.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/consul/paymentConsul")
    public String paymentConsul() {
        log.info("com.cloud.consul.controller.ConsulController.paymentConsul");
        return "spring with consul: " + port + "\t" + UUID.randomUUID().toString();
    }
}
