package com.cloud.order.controller;

import com.cloud.order.client.ProviderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
//@RequestMapping
public class OrderController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private ProviderClient providerProxy;

    @GetMapping("/consul/consumer/payInfo")
    public String payInfo(){
        log.info("11111111111111");
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul/paymentConsul", String.class);
        return providerProxy.paymentConsul();
    }

}
