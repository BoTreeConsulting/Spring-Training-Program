package com.botreeconsulting.basicaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageManipulator implements MethodInterceptor{
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("Hello ");
		Object retVal = invocation.proceed();
		System.out.print("!!!!");
		return retVal;
	}
}
