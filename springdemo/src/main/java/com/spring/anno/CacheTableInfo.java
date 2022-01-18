package com.spring.anno;

import com.cloud.common.enumeration.CacheOperationEnum;

import java.lang.annotation.*;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 18:51
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheTableInfo {

    String table();

    CacheOperationEnum operation() default CacheOperationEnum.SELECT;

    Class returnType() default Object.class;
}
