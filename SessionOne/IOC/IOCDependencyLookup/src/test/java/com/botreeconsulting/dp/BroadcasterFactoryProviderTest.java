package com.botreeconsulting.dp;

import junit.framework.TestCase;

import org.junit.Test;

public class BroadcasterFactoryProviderTest extends TestCase{
	
	@Test
	public void testBeanFactory(){
		Broadcaster broadcaster = (Broadcaster)BeanFactoryProvider
				.getBeanFactory("/applicationContext.xml")
				.getBean("broadcaster");
		assertNotNull(broadcaster);
	}	
}
