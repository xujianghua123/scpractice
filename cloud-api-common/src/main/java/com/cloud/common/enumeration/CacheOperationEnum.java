package com.cloud.common.enumeration;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 18:53
 */
public enum CacheOperationEnum {

    SELECT(0,"查询"),
    ADD(1,"添加"),
    ;
    private Integer operation;

    private String description;


    CacheOperationEnum(Integer operation, String description) {
        this.operation = operation;
        this.description = description;
    }

    public Integer getOperation() {
        return operation;
    }

    public String getDescription() {
        return description;
    }
}
