package com.example.mingyang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloAspect
 *
 * @author XuYang
 * @since 2024/6/19 13:42
 */
// @Aspect
// @Component
public class HelloAspect1 {

	/**
	 * public Object invoke(MethodInvocation mi) throws Throwable {
	 * this.advice.before(mi.getMethod(), mi.getArguments(), mi.getThis());
	 * return mi.proceed();
	 * }
	 */
	@Before("@annotation(getMapping)")
	public void before(JoinPoint joinPoint, GetMapping getMapping) {
		System.out.println("Before....1");
	}

	/**
	 * around通知正常执行即可，开发者编写的逻辑中肯定得有point.proceed()
	 * public Object invoke(MethodInvocation mi) throws Throwable {
	 * ProxyMethodInvocation pmi = (ProxyMethodInvocation) mi;
	 * ProceedingJoinPoint pjp = lazyGetProceedingJoinPoint(pmi);
	 * JoinPointMatch jpm = getJoinPointMatch(pmi);
	 * return invokeAdviceMethod(pjp, jpm, null, null);
	 * }
	 */
	@Around("@annotation(getMapping)")
	public Object around(ProceedingJoinPoint point, GetMapping getMapping) throws Throwable {
		System.out.println("Around---Before1");
		Object proceed = point.proceed();
		System.out.println("Around---After1");
		return proceed;
	}

	/**
	 * after对应的逻辑 是写在finally块中的，因此一定会执行，但并不代表一定是最后一个执行。
	 * public Object invoke(MethodInvocation mi) throws Throwable {
	 * try {
	 * return mi.proceed();
	 * }
	 * finally {
	 * // 很显然，finally中的afterAdvice一定会执行
	 * invokeAdviceMethod(getJoinPointMatch(), null, null);
	 * }
	 * }
	 */
	@After("@annotation(getMapping)")
	public void after(JoinPoint point, GetMapping getMapping) {
		System.out.println("After....1");
	}

	/**
	 * public Object invoke(MethodInvocation mi) throws Throwable {
	 * Object retVal = mi.proceed();
	 * this.advice.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
	 * return retVal;
	 * }
	 */
	@AfterReturning(pointcut = "@annotation(getMapping)", returning = "result")
	public void afterReturning(Object result, GetMapping getMapping) {
		System.out.println("AfterReturning...1：" + result);
	}

	/**
	 * public Object invoke(MethodInvocation mi) throws Throwable {
	 * try {
	 * return mi.proceed();
	 * }
	 * catch (Throwable ex) {
	 * // 出现异常，再次抛出之前，检查需不需要执行异常通知
	 * if (shouldInvokeOnThrowing(ex)) {
	 * invokeAdviceMethod(getJoinPointMatch(), null, ex);
	 * }
	 * throw ex;
	 * }*
	 * }
	 */
	@AfterThrowing(pointcut = "@annotation(getMapping)", throwing = "ex")
	public void afterThrowing(Throwable ex, GetMapping getMapping) {
		System.out.println("AfterThrowing...1：" + ex.getMessage());
	}

}
