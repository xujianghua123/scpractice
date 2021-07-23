package com.cloud.common.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
* @Description: 自营仓库存调整枚举
* @Author: xujianghua
* @Date: 2021/7/22 15:43
*/
public class InventoryAdjustEnum {

    /**
     * @Description: 业务类型枚举
     * @Author: xujianghua
     * @Date: 2021/7/22 15:45
     */
    public enum BusinessType {
        PHYSICAL_COMMODITY(0,"实体商品调整"),
        LOGISTICS_MATERIALS(1,"物流辅料调整"),
        ;

        private Integer code;

        private String desc;

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        BusinessType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static String getDescByCode(Integer code){
            BusinessType[] values = BusinessType.values();
            for(BusinessType val:values){
                if(val.getCode().equals(code)){
                    return val.getDesc();
                }
            }
            return "";
        }

        public static Map<String, String> getEnumMap() {
            Map<String, String> resMap = new HashMap<>();
            BusinessType[] values = BusinessType.values();
            for(BusinessType val:values){
                resMap.put(val.getCode().toString(),val.getDesc());
            }
            return resMap;
        }
    }

    /**
     * @Description: 调整类型枚举
     * @Author: xujianghua
     * @Date: 2021/7/22 15:44
     */
    public enum AdjustType {
        PHYSICAL_COMMODITY(0,"库存增加"),
        LOGISTICS_MATERIALS(1,"库存减少"),
        ;

        private Integer code;

        private String desc;

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        AdjustType(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static String getDescByCode(Integer code){
            AdjustType[] values = AdjustType.values();
            for(AdjustType val:values){
                if(val.getCode().equals(code)){
                    return val.getDesc();
                }
            }
            return "";
        }

        public static Map<String, String> getEnumMap() {
            Map<String, String> resMap = new HashMap<>();
            AdjustType[] values = AdjustType.values();
            for(AdjustType val:values){
                resMap.put(val.getCode().toString(),val.getDesc());
            }
            return resMap;
        }
    }
}
