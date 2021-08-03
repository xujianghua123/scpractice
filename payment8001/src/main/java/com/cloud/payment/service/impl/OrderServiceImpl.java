package com.cloud.payment.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.cloud.common.entities.Order;
import com.cloud.payment.dao.OrderDao;
import com.cloud.payment.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(Order order) {
        int resNum = orderDao.create(order);
//        if(resNum > 0){
//            throw new RuntimeException("tr test ！！！");
//        }
        return resNum;
    }

    @Override
    public Object delete(int id) {
        return orderDao.delete(id);
    }

    @Override
    public Object update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public Order load(int id) {
        return orderDao.load(id);
    }

    @Override
    public Map<String, Object> pageList(int offset, int pagesize) {
        return null;
    }
}
