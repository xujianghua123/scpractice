package com.spring.service;

import com.cloud.common.constant.TableNameConstant;
import com.cloud.common.entities.Order;
import com.cloud.common.enumeration.CacheOperationEnum;
import com.spring.anno.CacheTableInfo;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 20:49
 */
@Service
public class OrderService {

    @CacheTableInfo(table = TableNameConstant.T_ORDER,returnType = Order.class)
    public Order getOrder(){
        System.out.println("------------ select order service ------------");
       return new Order(2000L,"2000000");
    }

    @CacheTableInfo(table = TableNameConstant.T_ORDER,operation = CacheOperationEnum.ADD)
    public void addOrder(){
        System.out.println("------------ add order service ----------");
    }
}
