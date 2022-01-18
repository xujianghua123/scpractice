package com.spring.config;

import com.cloud.common.constant.TableNameConstant;
import com.spring.common.AbstractTableInfo;
import com.spring.common.OrderTableInfo;
import com.spring.common.UserTableInfo;
import com.spring.service.Service2Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/22 19:42
 */

@Configuration
public class CommonConfig {

    @Bean
    public Map<String, AbstractTableInfo> tableInfoMap(){
        Map<String,AbstractTableInfo> tableInfoMap = new ConcurrentHashMap<>(8);
        tableInfoMap.put(TableNameConstant.T_ORDER,new OrderTableInfo());
        tableInfoMap.put(TableNameConstant.T_USER,new UserTableInfo());
        return tableInfoMap;
    }
}
