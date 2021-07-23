package com.cloud.common.enumeration;

/**
* @Description:
* @Author: xujianghua
* @Date: 2021/7/23 17:43
*/
public enum CommonQueryEnum {

    INVENTORY_ADJUST_ADJUST_TYPE(1001,InventoryAdjustEnum.AdjustType.class,"库存调整-调整类型"),
    INVENTORY_ADJUST_BUSINESS_TYPE(1002,InventoryAdjustEnum.BusinessType.class,"库存调整-业务类型"),
    ;

    private Integer code;

    private Class enumObj;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Class getEnumObj() {
        return enumObj;
    }

    CommonQueryEnum(Integer code, Class enumObj, String desc) {
        this.code = code;
        this.enumObj = enumObj;
        this.desc = desc;
    }

    public static boolean containsCode(Integer code){
        CommonQueryEnum[] values = CommonQueryEnum.values();
        for(CommonQueryEnum val:values){
            if(val.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public static String getDescByCode(Integer code){
        CommonQueryEnum[] values = CommonQueryEnum.values();
        for(CommonQueryEnum val:values){
            if(val.getCode().equals(code)){
                return val.getDesc();
            }
        }
        return null;
    }

    public static Class getEnumObjByCode(Integer code){
        CommonQueryEnum[] values = CommonQueryEnum.values();
        for(CommonQueryEnum val:values){
            if(val.getCode().equals(code)){
                return val.getEnumObj();
            }
        }
        return null;
    }
}

