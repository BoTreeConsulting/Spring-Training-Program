package com.botreeconsulting.basicaop;

import org.springframework.beans.factory.BeanFactory;

import com.botreeconsulting.basicaop.util.BeanFactoryProvider;
import com.botreeconsulting.basicaop.util.ProxyProvider;

public class HelloWorldAOP {
	
	public static void main(String[] args) {
	
		BeanFactory beanfactory = BeanFactoryProvider
		.getBeanFactory("/applicationContext.xml"); 
		
		MessageBroadcaster messageBroadcasterTarget = 
			(MessageBroadcaster)beanfactory
			.getBean("messageBroadcaster");
		
		//messageBroadcasterTarget.broadcast();
		
		//Weaving of Advice
		
		ProxyProvider proxyProvider =(ProxyProvider)beanfactory
		.getBean("proxyProvider");
		MessageBroadcaster messageBroadcasterProxy =  
			proxyProvider.getMessageBroadcasterProxy(args[0], messageBroadcasterTarget);
		messageBroadcasterProxy.broadcast();
				
	}
}
