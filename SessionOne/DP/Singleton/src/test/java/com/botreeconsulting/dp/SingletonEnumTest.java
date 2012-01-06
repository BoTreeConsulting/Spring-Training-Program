package com.botreeconsulting.dp;

import junit.framework.TestCase;

import org.junit.Test;

import com.botreeconsulting.dp.singleton.useenum.Singleton;

public class SingletonEnumTest extends TestCase{
	
	@Test
	public void testIfInstanceSame(){
		assertEquals(Singleton.INSTANCE, Singleton.INSTANCE);
	}	
}
