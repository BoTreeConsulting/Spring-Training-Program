package com.botreeconsulting.aop;

import org.springframework.beans.factory.BeanFactory;

public class HelloWorldSpringAOP {

	public static void main(String[] args) {
		BeanFactory beanFactory = BeanFactoryProvider.getBeanFactory("/applicationContext.xml");		
		Broadcaster broadcaster = (Broadcaster)beanFactory.getBean("broadcasterProxy");
		broadcaster.broadcast();
	}
}
