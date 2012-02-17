package com.botreeconsulting.aop;

import org.springframework.aop.framework.ProxyFactory;

public class ProxyProvider {
	
	protected ProxyFactory proxyFactory;
	
	public void setProxyFactory(ProxyFactory proxyFactory) {
		this.proxyFactory = proxyFactory;
	}
}