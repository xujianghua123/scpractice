package com.cloud.common.enumeration;

import com.cloud.common.entities.Order;
import com.cloud.common.entities.User;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 18:53
 */
public enum TableNameEnum {

    USER("t_user","用户信息表", User.class),
    ORDER("t_order","订单表", Order.class),
    ;
     private String tableName;

    private String description;

    private Class clazz;


    TableNameEnum(String tableName, String description,Class clazz) {
        this.tableName = tableName;
        this.description = description;
        this.clazz = clazz;
    }

    public String getTableName() {
        return tableName;
    }

    public Class getClz() {
        return clazz;
    }

    public static Class getByTableName(String tableName){
        TableNameEnum[] values = TableNameEnum.values();
        for(TableNameEnum val:values){
            if(val.getTableName().equals(tableName)){
                return val.getClz();
            }
        }
        return null;
    }
}
