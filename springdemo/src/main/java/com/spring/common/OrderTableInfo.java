package com.spring.common;

import com.cloud.common.entities.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/22 14:13
 */
@Component
public class OrderTableInfo extends AbstractTableInfo {

    @Override
    public Order getTableInfo() {
        return new Order(1000L,"1000000");
    }

    @Override
    public void addCache(String id) {

    }
}
