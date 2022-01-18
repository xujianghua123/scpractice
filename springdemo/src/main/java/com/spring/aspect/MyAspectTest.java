package com.spring.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectTest {

//	@Pointcut("@annotation(com.spring.anno.AspectAnno)")
	@Pointcut("execution(* com.h.test.spring..*.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void before(){
		System.out.println("aspect 前置通知");
	}

	@After("pointCut()")
	public void after(){
		System.out.println("aspect 后置通知");
	}

//	@Around("pointCut()")
//	public void around(){
//		System.out.println("aspect 环绕通知");
//	}

	@AfterThrowing("pointCut()")
	public void exception(){
		System.out.println("aspect 异常通知");
	}

	@AfterReturning("pointCut()")
	public void afterReturn(){
		System.out.println("aspect 后置返回通知");
	}
}


