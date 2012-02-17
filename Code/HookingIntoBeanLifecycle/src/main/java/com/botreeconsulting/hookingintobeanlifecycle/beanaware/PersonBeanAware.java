package com.botreeconsulting.hookingintobeanlifecycle.beanaware;

import org.springframework.beans.factory.InitializingBean;

public class PersonBeanAware implements InitializingBean{
	private String firstName;
	private String lastName;
	
	public PersonBeanAware() {
		System.out.println("Invoking the InitializingBean Default Constructor!");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In InitializingBean afterSetProperties!");	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
