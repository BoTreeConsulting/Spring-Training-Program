package com.botreeconsulting.basicaop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("Invoked Before Method Name : " + method.getName());
	}
}
