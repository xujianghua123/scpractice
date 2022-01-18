package com.spring.service;

import com.cloud.common.constant.TableNameConstant;
import com.cloud.common.entities.User;
import com.cloud.common.enumeration.CacheOperationEnum;
import com.spring.anno.CacheTableInfo;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

@Component
public class UserService {

    volatile PriorityQueue<Integer> msg = new PriorityQueue();

    @CacheTableInfo(table = TableNameConstant.T_USER,operation = CacheOperationEnum.ADD)
    public void addUser(){
        System.out.println("add user service");
    }

    @CacheTableInfo(table = TableNameConstant.T_USER)
    public User getUser(Long id,String name){
        System.out.println("query user service");
        return new User(2L,"222","2222");
    }

}
