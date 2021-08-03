package com.cloud.payment.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.cloud.common.entities.Order;
import com.cloud.common.entities.Payment;
import com.cloud.payment.dao.OrderDao;
import com.cloud.payment.dao.PaymentDao;
import com.cloud.payment.service.OrderService;
import com.cloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderService orderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(Payment payment) {
        payment.setSerial(UUID.randomUUID().toString());
        int resNum = paymentDao.create(payment);
        orderService.insert(this.orderParamHandle());
        if(resNum > 0){
            throw new RuntimeException("tr test ！！！");
        }
        return resNum;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    private Order orderParamHandle(){
        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        order.setPrice(RandomUtil.randomBigDecimal(new BigDecimal(10),new BigDecimal(100)));
        order.setQuantity(RandomUtil.randomInt(1,100));
        order.setOrderTime(new Date());
        return order;
    }
}
