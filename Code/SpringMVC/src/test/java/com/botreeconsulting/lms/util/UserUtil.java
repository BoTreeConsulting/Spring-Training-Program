package com.botreeconsulting.lms.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.botreeconsulting.lms.model.Role;
import com.botreeconsulting.lms.model.User;

public class UserUtil extends EntityUtil<User, Long> {

	public UserUtil(Session session, Class<User> entityClass) {
		super(session, entityClass);
	}
	
	public static final String FIRST_NAME_JIGNESH = "Jignesh";
	public static final int FIRST_NAME_JIGNESH_EXPECTED_RESULTS_COUNT = 1;
	
	public static final String LAST_NAME_GOHEL = "Gohel";
	public static final int LAST_NAME_GOHEL_EXPECTED_RESULTS_COUNT = 2;
	
	public static final int BORROWER_ROLE_EXPECTED_RESULTS_COUNT = 3;
	
	private static final String[][] TEST_USERS = {
		// Format -> {first name, last name, contactNumber, address, role}
		{"Jignesh", "Gohel", "123456", "Ahmedabad", "0"},
		{"Dharti", "Gohel", "159753", "Ahmedabad", "0"},
		{"Shardul", "Bhatt", "2456878", "Vadodara", "1"},
		{"Amit", "Patel", "236541", "Gadhda", "0"},
	};
	
	private static final String FIRST_NAME_PROPERTY = "firstName";
	private static final String LAST_NAME_PROPERTY = "lastName";
	private static final String ROLE_PROPERTY = "role";
	
	/**
	 * 
	 * @param firstName the first name
	 * 
	 * @return a {@link List} holding {@link User} instances having the
	 * specified <code>firstName</code> or an empty list if no users
	 * could be found into the system having the specified <code>firstName</code> 
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUsersByFirstName(String firstName) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(firstName)) {
			criteria.add(Restrictions.ilike(FIRST_NAME_PROPERTY, firstName));
			return criteria.list();
		}
		
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @param lastName the last name
	 * 
	 * @return a {@link List} holding {@link User} instances having the
	 * specified <code>lastName</code> or an empty list if no users
	 * could be found into the system having the specified <code>lastName</code> 
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUsersByLastName(String lastName) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(lastName)) {
			criteria.add(Restrictions.ilike(LAST_NAME_PROPERTY, lastName));
			return criteria.list();
		}
		
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @param firstName the first name
	 * @param lastName the last name
	 * 
	 * @return the {@link User} instance having the specified 
	 * <code>firstName</code> and <code>lastName</code> or NULL if the {@link User}
	 * could not be found in the system for the specified 
	 * <code>firstName</code> and <code>lastName</code>
	 */
	public User findUserByFirstNameAndLastName(String firstName, String lastName) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(firstName) && StringUtil.isNotEmpty(lastName)) {
			criteria.add(
					Restrictions.and(
							Restrictions.eq(FIRST_NAME_PROPERTY, firstName), 
							Restrictions.eq(LAST_NAME_PROPERTY, lastName)));
			return (User) criteria.uniqueResult();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param role the {@link Role} enum constant
	 * 
	 * @return a {@link List} holding {@link User} instances having the
	 * specified <code>role</code> or an empty list if no users
	 * could be found into the system having the specified <code>role</code>  
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUsersByRole(Role role) {
		Criteria criteria = getCriteriaForEntity();
		
		if (role != null) {
			criteria.add(Restrictions.eq(ROLE_PROPERTY, role));
			return criteria.list();
		}
		
		return Collections.emptyList();
	}
	/**
	 * 
	 * @return
	 */
	public static final List<User> getTestUsers() {
		List<User> testUsers = new ArrayList<User>(TEST_USERS.length);
		
		for (String[] testUser : TEST_USERS) {
			testUsers.add(
					getTestUser(testUser[0], 
							testUser[1], 
							testUser[2], 
							testUser[3],
							testUser[4]));
					
		}
		return testUsers;
	}
	
	private static User getTestUser(
			String firstName, String lastName, String contactNumber, 
			String address, String role) {
		
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setContactNumber(contactNumber);
		user.setAddress(address);
		user.setRole(Role.convert(role));
		
		return user;
	}

}
