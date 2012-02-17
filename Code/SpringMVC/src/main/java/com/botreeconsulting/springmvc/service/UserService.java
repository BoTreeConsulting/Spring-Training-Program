package com.botreeconsulting.springmvc.service;

import java.util.List;

import com.botreeconsulting.springmvc.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User addUser(User user);

	public User getUser(Long id);

	public User updateUser(User user);
}
