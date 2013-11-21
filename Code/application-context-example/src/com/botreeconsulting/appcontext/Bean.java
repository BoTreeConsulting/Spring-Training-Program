package com.botreeconsulting.appcontext;

public class Bean {
	
	public static Bean getInstance() {
		System.out.println("getInstance Called");
		return new Bean();
	}

}
