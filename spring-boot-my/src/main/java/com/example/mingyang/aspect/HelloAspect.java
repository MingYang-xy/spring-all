package com.example.mingyang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloAspect
 *
 * @author XuYang
 * @since 2024/6/19 13:42
 */
@Aspect
@Component
public class HelloAspect {

	@Before("@annotation(getMapping)")
	public void before(JoinPoint joinPoint, GetMapping getMapping) {
		System.out.println("前置增强逻辑");
	}

	@Around("@annotation(getMapping)")
	public Object around(ProceedingJoinPoint point, GetMapping getMapping) throws Throwable {
		System.out.println("前置-环绕增强逻辑");
		Object proceed = point.proceed();
		System.out.println("后置-环绕增强逻辑");
		return proceed;
	}

	@After("@annotation(getMapping)")
	public void after(JoinPoint point, GetMapping getMapping) {
		System.out.println("后置增强逻辑");
	}
}
