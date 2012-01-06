package com.botreeconsulting.lms.hibernate.xml.model;

public enum Role {
	BORROWER("0"), ISSUER("1");
	
	private final String val;
	
	private Role(String val) {
		this.val = val;
	}
	
	public String getVal() {
		return val;
	}
	
	public static final Role convert(String val) {
		for (Role role : values()) {
			if (role.getVal().equals(val)) {
				return role;
			}
		}
		return null;
	}
}
