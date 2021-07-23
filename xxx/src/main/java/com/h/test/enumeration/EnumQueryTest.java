package com.h.test.enumeration;

import com.cloud.common.enumeration.CommonQueryEnum;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/**
* @Description:
* @Author: xujianghua
* @Date: 2021/7/23 17:42
*/
public class EnumQueryTest {

    @Test
    public void test() throws Exception {
        Class descByCode = CommonQueryEnum.getEnumObjByCode(1002);
        Object[] enumConstants = descByCode.getEnumConstants();
        System.out.println("---------------------------------枚举类--------------------------------");
        for(Object e: enumConstants){
            System.out.println(e);
        }
        Method[] methods = descByCode.getDeclaredMethods();
        System.out.println("---------------------------------枚举集合--------------------------------");
        Method method = descByCode.getDeclaredMethod("getEnumMap", null);
        method.setAccessible(true);
        Map<String,String> resMap = (Map<String,String>)method.invoke(null);
        Iterator<Map.Entry<String, String>> iterator = resMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key:" + next.getKey() + "\t value:" + next.getValue());
        }


    }
}
