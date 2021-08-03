package com.cloud.payment.controller;

import com.cloud.common.api.CommonResult;
import com.cloud.common.entities.Order;
import com.cloud.common.entities.Payment;
import com.cloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/order/create")
    public CommonResult create(Order order){
//        int result = paymentService.create(payment);
        int result = 1;
        log.info("插入结果="+result);

        if (result > 0){
            return  CommonResult.success(result,"插入数据成功");
        }else{
            return CommonResult.failed("插入数据失败");
        }
    }


    @GetMapping(value = "/order/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
//        Payment payment = paymentService.getPaymentById(id);
        Payment payment = initPayment(id);
        log.info("查询结果="+payment);

        if (Objects.nonNull(payment)){
            return  CommonResult.success(payment,"查询数据成功");
        }else{
            return CommonResult.failed("查询数据失败");
        }
    }

    private Payment initPayment(Long id){
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSerial("xuxuxuxu");
        if(id != 1){
            return null;
        }
        return payment;
    }
}
