package com.spring.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 20:54
 */
public abstract class AbstractTableInfo<T> {

    private Map<String,AbstractTableInfo> tableInfoMap = new ConcurrentHashMap<>(8);

    @Autowired
    private OrderTableInfo orderTableInfo;

    @Autowired
    private UserTableInfo userTableInfo;

    public abstract T getTableInfo();

    public abstract void addCache(String id);
}
