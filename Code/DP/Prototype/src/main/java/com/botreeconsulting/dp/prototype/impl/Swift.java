package com.botreeconsulting.dp.prototype.impl;

import com.botreeconsulting.dp.prototype.Car;

public class Swift extends Car {
	
	public Swift() {
		make = "Maruti Suzuki";
		model = "Swift";
		System.out.println("Created Complecated and Expensive Object 'Maruti Suzuki Swift'");
	}
	
	/**
	 * Calls {@link Car#clone()} super class method to construct superclass object and set states
	 * 
	 * @return new instance of {@link Swift}
	 */
	@Override
	public Swift clone() {
		
		Swift clonedSwift = null;
		
		clonedSwift = (Swift) super.clone();
		
		// Set 'Maruti Suzuki Swift' specific states here
		
		System.out.println("'Maruti Suzuki Swift' Cloned");
		
		return clonedSwift;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!(obj instanceof Swift))
			return false;
		
		Swift anotherSwift = (Swift) obj;
		
		if (this.make.equals(anotherSwift.make)
				&& this.model.equals(anotherSwift.model))
			return true;
		
		return false;
	}
}
