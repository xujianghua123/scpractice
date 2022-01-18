package com.spring.aspect;

import com.spring.anno.CacheTableInfo;
import com.spring.common.AbstractTableInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 19:04
 */
@Aspect
@Component
public class QueryCacheAspect {

    @Around("@annotation(cacheTableInfo)")
    public <T> T around(ProceedingJoinPoint joinPoint, CacheTableInfo cacheTableInfo) throws Throwable {

        Object[] args = joinPoint.getArgs();
        for(Object arg:args){
            if(arg instanceof String){
                System.out.println(arg);
                break;
            }
        }

        T proceed = (T)joinPoint.proceed();

        //  执行添加缓存
        return proceed;
    }
}
