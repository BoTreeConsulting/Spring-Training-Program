package com.botreeconsulting.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLHelperTest {

	@Test
	public void testGetFullyQualifiedClassNameFromBeanName() {
		
		String fullyQualifiedClass = XMLHelper.getFullyQualifiedClass("car");
		
		assertNotNull(fullyQualifiedClass);
		
		assertEquals("com.botreeconsulting.ioc.Car", fullyQualifiedClass);
		
	}

}
