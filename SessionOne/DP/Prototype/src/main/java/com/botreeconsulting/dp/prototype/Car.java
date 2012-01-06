package com.botreeconsulting.dp.prototype;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class Car implements Cloneable{
	
	protected String make;
	protected String model;
	
	/**
	 * Use Prototype when creating of object is either expensive or complecated 
	 * 
	 * @return newly created instance of {@link Car}
	 */
	@Override
	public Car clone(){
		
		Car clonedCar = null;
				
		try {
			// 1. Clone
			clonedCar = (Car) super.clone();
		
			// 2. Align states with current object
			clonedCar.make = make;
			clonedCar.model = model;
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clonedCar;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("make", make)
			.append("model", model)
			.append("hashCode", hashCode())
			.toString();
	}
}
