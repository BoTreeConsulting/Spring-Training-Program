package com.botreeconsulting.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class BroadcastAdvice implements MethodBeforeAdvice, AfterReturningAdvice{
	
	public void before(Method method, Object args[], Object target){
		System.out.println("This is a Call Before Advice");
	}
	
	public void afterReturning(Object returnValue, Method method, Object args[], Object target){
		System.out.println("This is a Call After Advice");
	}
	
	/*public void afterThrowing(Throwable throwable){
		System.out.println("An Exception is Thrown");
	}*/
}
