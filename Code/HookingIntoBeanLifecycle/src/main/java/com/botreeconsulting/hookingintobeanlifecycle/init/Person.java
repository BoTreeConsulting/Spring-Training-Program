package com.botreeconsulting.hookingintobeanlifecycle.init;

public class Person {
	private String firstName;
	private String lastName;
	
	public Person() {
		System.out.println("Invoking the Default Constructor!");
	}
	
	public void init(){
		System.out.println("Invoking the Init method!");
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
