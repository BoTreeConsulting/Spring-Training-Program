package com.botreeconsulting.basicaop.util;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

import com.botreeconsulting.basicaop.AfterAdvice;
import com.botreeconsulting.basicaop.BeforeAdvice;
import com.botreeconsulting.basicaop.MessageBroadcaster;
import com.botreeconsulting.basicaop.MessageManipulator;
import com.botreeconsulting.basicaop.nextstep.BeanOne;
import com.botreeconsulting.basicaop.nextstep.BeanTwo;
import com.botreeconsulting.basicaop.nextstep.SimpleAdvice;

public class ProxyProvider {
	
	protected ProxyFactory proxyFactory;
	
	protected MessageManipulator messageManipulator;
	
	protected BeforeAdvice beforeAdvice;
	
	protected AfterAdvice afterAdvice;
	
	protected SimpleAdvice simpleAdvice;
	
	public void setProxyFactory(ProxyFactory proxyFactory) {
		this.proxyFactory = proxyFactory;
	}

	public void setMessageManipulator(MessageManipulator messageManipulator) {
		this.messageManipulator = messageManipulator;
	}
		
	public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
		this.beforeAdvice = beforeAdvice;
	}

	public void setAfterAdvice(AfterAdvice afterAdvice) {
		this.afterAdvice = afterAdvice;
	}

	public void setSimpleAdvice(SimpleAdvice simpleAdvice) {
		this.simpleAdvice = simpleAdvice;
	}

	public MessageBroadcaster getMessageBroadcasterProxy(String adviceType, MessageBroadcaster messageBroadcasterTarget){
				
		if(adviceType.equalsIgnoreCase("Basic")){
			proxyFactory.addAdvice(messageManipulator);
		}else if(adviceType.equalsIgnoreCase("BeforeAdvice")){
			proxyFactory.addAdvice(beforeAdvice);
		}else if(adviceType.equalsIgnoreCase("AfterAdvice")){
			proxyFactory.addAdvice(afterAdvice);
		}
		
		proxyFactory.setTarget(messageBroadcasterTarget);
				
		return (MessageBroadcaster)proxyFactory.getProxy();
	}
	
	public BeanOne getBeanOneProxy(BeanOne beanOneTarget, Advisor advisor){
		
		proxyFactory.addAdvisor(advisor);
		proxyFactory.setTarget(beanOneTarget);
		
		return (BeanOne)proxyFactory.getProxy();		
	}
	
	public BeanTwo getBeanTwoProxy(BeanTwo beanTwoTarget, Advisor advisor){
		
		proxyFactory.addAdvisor(advisor);
		proxyFactory.setTarget(beanTwoTarget);
		
		return (BeanTwo)proxyFactory.getProxy();		
	}
	
}