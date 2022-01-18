package com.spring.common;

import com.cloud.common.entities.User;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 20:59
 */
@Component
public class UserTableInfo extends AbstractTableInfo {

    @Override
    public User getTableInfo() {
//        return new User(1L,"111","cache");
        return null;
    }


    @Override
    public void addCache(String id) {
        System.out.println("cache success");
    }
}
