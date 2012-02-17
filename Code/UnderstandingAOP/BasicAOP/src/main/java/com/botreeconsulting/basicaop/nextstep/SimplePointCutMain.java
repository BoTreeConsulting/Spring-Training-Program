package com.botreeconsulting.basicaop.nextstep;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.BeanFactory;

import com.botreeconsulting.basicaop.util.BeanFactoryProvider;
import com.botreeconsulting.basicaop.util.ProxyProvider;

public class SimplePointCutMain {
	
	public static void main(String[] args) {
        
		BeanFactory beanfactory = BeanFactoryProvider.getBeanFactory("/applicationContext.xml");
				
		BeanOne one = (BeanOne)beanfactory.getBean("beanOne");
        BeanTwo two = (BeanTwo)beanfactory.getBean("beanTwo");
            
        //Create Pointcut
        Pointcut pointcut = (SimpleStaticPointcut)beanfactory.getBean("simpleStaticPointcut");;
        //Create Advice
        Advice advice = (SimpleAdvice)beanfactory.getBean("simpleAdvice");
        //Create Advisor
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        
        //Create proxies        
        ProxyProvider proxyProvider =(ProxyProvider)beanfactory.getBean("proxyProvider");        
        BeanOne proxyOne = (BeanOne)proxyProvider.getBeanOneProxy(one, advisor);
        proxyOne.foo();
        proxyOne.bar();
        
        BeanTwo proxyTwo = (BeanTwo)proxyProvider.getBeanTwoProxy(two, advisor);
        proxyTwo.foo();
        proxyTwo.bar();        
    }
}