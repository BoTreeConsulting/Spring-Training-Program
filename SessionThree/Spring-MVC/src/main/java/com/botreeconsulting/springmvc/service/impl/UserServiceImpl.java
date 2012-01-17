package com.botreeconsulting.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.botreeconsulting.springmvc.model.User;
import com.botreeconsulting.springmvc.service.UserService;
import com.botreeconsulting.springmvc.util.StaticData;

@Service("userService")
public class UserServiceImpl implements UserService {

	
	@Override
	public List<User> getAllUsers() {
		return new ArrayList<User>(StaticData.getUsersMap().values());
	}

	@Override
	public User addUser(User user) {
		
		Map<Long, User> usersMap = StaticData.getUsersMap();
		
		// Generate Id
		Long id = new Long(usersMap.size()+1);
		user.setId(id);
		
		usersMap.put(id, user);
		
		return user;
	}

	@Override
	public User getUser(Long id) {
		
		return StaticData.getUsersMap().get(id);
		
	}

	@Override
	public User updateUser(User user) {
		
		Map<Long, User> usersMap = StaticData.getUsersMap();
		
		User oldUser = usersMap.get(user.getId());
		
		if(oldUser !=null) {
			usersMap.put(user.getId(), user);	
		} else {
			user = null;
		}
		
		return user;	
	}

}
