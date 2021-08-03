package com.cloud.payment.service;

import com.cloud.common.entities.Order;

import java.util.Map;

public interface OrderService {
    /**
     * 新增
     */
    Object insert(Order order);

    /**
     * 删除
     */
    Object delete(int id);

    /**
     * 更新
     */
    Object update(Order order);

    /**
     * 根据主键 id 查询
     */
    Order load(int id);

    /**
     * 分页查询
     */
    Map<String,Object> pageList(int offset, int pagesize);
}
