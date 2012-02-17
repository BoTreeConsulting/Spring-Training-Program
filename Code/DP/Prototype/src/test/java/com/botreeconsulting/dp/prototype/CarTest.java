package com.botreeconsulting.dp.prototype;

import static org.junit.Assert.*;

import org.junit.Test;

import com.botreeconsulting.dp.prototype.impl.Swift;

public class CarTest {

	@Test
	public void testClonedSwiftCar() {
		
		// 1. Create first Swift object
		Car swiftOrginal = new Swift();
		
		System.out.println(swiftOrginal);
		
		// 2. Create Prototype
		Car swiftCloned = swiftOrginal.clone();
		
		System.out.println(swiftCloned);
		
		// 3. Should not be null
		assertNotNull(swiftCloned);
		
		// 4. Check internal presentation(State) is same
		assertEquals(swiftOrginal, swiftCloned);
		
		// 5. Check both are different objects
		assertFalse(swiftCloned.hashCode() == swiftOrginal.hashCode());
	}

}
