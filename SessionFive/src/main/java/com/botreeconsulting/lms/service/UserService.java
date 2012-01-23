package com.botreeconsulting.lms.service;

import java.util.List;

import com.botreeconsulting.lms.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User addUser(User user);

	public User getUser(Long id);

	public User updateUser(User user);
}
