package com.botreeconsulting.dl;

import junit.framework.TestCase;

public class BroadcasterFactoryProviderTest extends TestCase{
	
	public void testBeanFactory(){
		Broadcaster broadcaster = (Broadcaster)BeanFactoryProvider
				.getBeanFactory("/applicationContext.xml")
				.getBean("broadcaster");
		assertNotNull(broadcaster);
	}	
}
