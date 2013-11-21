package com.botreeconsulting.appcontext;

public class Author {
	
	String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Author : " + name;
	}

}
