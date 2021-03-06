package com.mq.rabbit.enumeration;

public enum QueueTypeEnum {

    HELLO_WORLD("helloworld","helloworld类型"),

    ;

    QueueTypeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescByCode(String code) {
        QueueTypeEnum queueTypeEnum = QueueTypeEnum.valueOf(code);
        return queueTypeEnum.getDesc();
    }

}
