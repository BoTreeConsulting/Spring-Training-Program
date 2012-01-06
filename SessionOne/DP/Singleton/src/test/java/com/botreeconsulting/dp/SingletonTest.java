package com.botreeconsulting.dp;

import com.botreeconsulting.dp.singleton.Singleton;

import junit.framework.TestCase;

public class SingletonTest extends TestCase {

	
	public void testMultipleInstances() {
		
		// Get instance of Singleton
		Singleton singleton1 = Singleton.getInstance();
		
		// Again get instance of Singleton
		Singleton singleton2 = Singleton.getInstance();
		
		// Compare both instances. It should be equal
		assertEquals(singleton1, singleton2); // You can test hashCode as well
	}
}
