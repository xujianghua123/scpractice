package com.spring.aspect;

import com.cloud.common.enumeration.CacheOperationEnum;
import com.spring.anno.CacheTableInfo;
import com.spring.common.AbstractTableInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 19:04
 */
//@Aspect
//@Component
public class CacheTableInfoAspect<T> {

    @Autowired
    private Map<String,AbstractTableInfo> tableInfoMap ;

    @Around("@annotation(cacheTableInfo)")
    public T around(ProceedingJoinPoint joinPoint, CacheTableInfo cacheTableInfo) throws Throwable {

        Object[] args = joinPoint.getArgs();
        for(Object arg:args){
            if(arg instanceof String){
                System.out.println(arg);
                break;
            }
        }

//        if(CacheOperationEnum.SELECT.equals(cacheTableInfo.operation())){
//            //  执行查询方法
//
//            Object tableInfo = tableInfoMap.get(cacheTableInfo.table()).getTableInfo();
//            if(Objects.nonNull(tableInfo)){
//                System.out.println("query 命中");
//                return (T) tableInfo;
//            }
//        }

        T proceed = (T)joinPoint.proceed();

        //  执行添加缓存
        return proceed;
    }

   /* @Before("@annotation(cacheTableInfo)")
    public void before(JoinPoint joinPoint, CacheTableInfo cacheTableInfo) throws Exception {

        if(CacheOperationEnum.ADD.equals(cacheTableInfo.operation())){
            return;
        }

        String userInfo = "{\"id\":1,\"userName\":\"xu\",\"userInfo\":\"123456\"}";

        //获得执行方法的类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获得执行方法的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取切点方法的所有参数类型
        Object[] arguments = joinPoint.getArgs();

//        Class clazz = joinPoint.getSignature().getDeclaringType();
//        Class<?> returnType = clazz.getMethod(joinPoint.getSignature().getName()).getReturnType();
//        Object o = returnType.newInstance();

        JSONObject jsonObject = JSONUtil.parseObj(userInfo);
        Class clz = TableNameEnum.getByTableName(cacheTableInfo.table());
        Object o = clz.newInstance();
        BeanUtils.copyProperties(jsonObject,o);
//        System.out.println(resultType);

        Object[] args = joinPoint.getArgs();
        System.out.println(args[0]);





        System.out.println(cacheTableInfo.table());
        System.out.println("aspect 前置通知");

    }

    @After("@annotation(cacheTableInfo)")
    public void after(JoinPoint joinPoint, CacheTableInfo cacheTableInfo){

        if(CacheOperationEnum.SELECT.equals(cacheTableInfo.operation())){
            return;
        }

        System.out.println("aspect 后置通知");
        System.out.println(cacheTableInfo.operation().getOperation());
    }*/

}
