package com.botreeconsulting.springmvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Member {
	
	@NotEmpty(message = "Name must not be blank.")
	@Size(min=2)
	private String name;
	
	@NotNull
	@Size(min = 10, max = 14, message = "Phone must be 10 to 14 characters.")
	private String phone;
	
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email")
	private String email;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
}
