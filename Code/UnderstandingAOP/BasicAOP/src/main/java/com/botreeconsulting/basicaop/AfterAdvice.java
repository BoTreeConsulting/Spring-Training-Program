package com.botreeconsulting.basicaop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object arg0, Method method, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println(" -- Invoked After Method Name : " + method.getName());
	}
}
