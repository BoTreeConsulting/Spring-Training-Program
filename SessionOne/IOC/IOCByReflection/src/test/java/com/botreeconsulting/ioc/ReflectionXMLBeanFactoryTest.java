package com.botreeconsulting.ioc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class ReflectionXMLBeanFactoryTest {
	
	ReflectionXMLBeanFactory factory ;
	
	@Before
	public void setUp() {
		
		factory = ReflectionXMLBeanFactory.getInstance();
		
	}
	
	@Test
	public void testGetCarInstance() {		
		Object bean = factory.getBean("car");		
		assertNotNull("Car instance should not be null", bean);		
		assertEquals(Car.class, bean.getClass());		
	}

	@Test(expected=NoSuchBeanDefinitionException.class)
	public void testNoSuchBeanDefinitionException() {
		factory.getBean("cart");
	}
	
	@Test
	public void testGetBusInstance() {		
		Object bean = factory.getBean("bus");		
		assertNotNull("Bus instance should not be null",bean);		
		assertEquals(Bus.class, bean.getClass());		
	}
}