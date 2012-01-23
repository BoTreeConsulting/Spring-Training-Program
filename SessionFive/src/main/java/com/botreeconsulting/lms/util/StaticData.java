package com.botreeconsulting.lms.util;

import java.util.HashMap;
import java.util.Map;

import com.botreeconsulting.lms.model.User;

public class StaticData {
	
	private static Map<Long, User> userMap = new HashMap<Long, User>();
	
	static {
		User user1 = new User();
		user1.setId(1L);
		user1.setFirstName("Shardul");
		user1.setLastName("Bhatt");
		user1.setAddress("Vastrapur");
		user1.setContactNumber("9427112233");
		userMap.put(user1.getId(), user1);
		
		User user2 = new User();
		user2.setId(2L);
		user2.setFirstName("Jignesh");
		user2.setLastName("Gohel");
		user2.setAddress("Vastrapur");
		user2.setContactNumber("9825001122");
		userMap.put(user2.getId(), user2);
	}
	
	public static Map<Long, User> getUsersMap() {
		return userMap;
	}
}
