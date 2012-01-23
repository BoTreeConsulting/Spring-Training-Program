package com.botreeconsulting.lms.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.botreeconsulting.lms.model.User;

@ContextConfiguration(locations="classpath:lms-service.xml")
public class UserTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	private UserService userService;
	
	@Test
	public void addUser() {
		
		User user = new User();
		user.setFirstName("Amit");
		user.setLastName("Patel");
		user.setContactNumber("12345678");
		
		User addedUser = userService.addUser(user);
		
		assertNotNull(addedUser);
		
		assertNotNull(addedUser.getId());
	}

	@Test
	public void getUser() {
		
		User user = userService.getUser(1L);
		
		assertNotNull(user);
		
	}
	
	@Test
	public void updateExistingUser() {
		
		User user = new User();
		user.setId(1L);
		user.setFirstName("Amit");
		user.setLastName("Patel");
		user.setContactNumber("12345678");
		
		User updatedUser = userService.updateUser(user);
		
		assertNotNull(updatedUser);
	}
	
	@Test
	public void updateNonExistingUser() {
		
		User user = new User();
		user.setId(100L);
		user.setFirstName("Amit");
		user.setLastName("Patel");
		user.setContactNumber("12345678");
		
		User udpateUser = userService.updateUser(user);
		
		assertNull(udpateUser);
	}
}
