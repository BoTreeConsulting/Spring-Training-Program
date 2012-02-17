package com.botreeconsulting.lms.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.botreeconsulting.lms.util.UserUtil;

public class UserTest extends GenericTestBase<User, Long> {

	private List<User> testUsers = null;
	private UserUtil userUtil = null;
	
	@Before
	public void addTestUsers() {
		Session session = openSession();
		
		// Create UserUtil
		userUtil = new UserUtil(session, User.class);
		
		// Set EntityUtil to UserUtil
		setEntityUtil(userUtil);
		
		// Get test users
		testUsers = UserUtil.getTestUsers();
		
		// add test users
		addTestEntities(testUsers);
	}
	
	@After
	public void deleteAllUsers() {
		deleteAllEntities();
		
		userUtil.getSession().close();
	}
	
	@Test
	public void testAddUser() {
		printTestName("testAddUser");
		for (User user : testUsers) {
			assertNotNull("Persisted User Id must not be null", user.getId());
		}
	}
	
	@Test
	public void findUsersByFirstName() {
		printTestName("findUsersByFirstName");
		List<User> users = userUtil.findUsersByFirstName(UserUtil.FIRST_NAME_JIGNESH);
		
		assertEquals("Count for the Users found by first name must match with " +
				"test users saved having the first name, provided to search by", 
				users.size(), UserUtil.FIRST_NAME_JIGNESH_EXPECTED_RESULTS_COUNT);
	}
	
	@Ignore
	public void findUsersByLastName() {
		printTestName("findUsersByLastName");
		List<User> users = userUtil.findUsersByLastName(UserUtil.LAST_NAME_GOHEL);
		
		assertEquals("Count for the Users found by last name must match with " +
				"test users saved having the last name, provided to search by", 
				users.size(), UserUtil.LAST_NAME_GOHEL_EXPECTED_RESULTS_COUNT);
	}
	
	@Ignore
	public void findUserByFirstAndLastName() {
		printTestName("findUserByFirstAndLastName");
		User user = userUtil.findUserByFirstNameAndLastName(
						UserUtil.FIRST_NAME_JIGNESH, UserUtil.LAST_NAME_GOHEL);
		assertNotNull("User instance found should not be null", user);
		assertEquals("Found user instance's first name must match with " +
				"user first name  provided to search by", 
				user.getFirstName(), UserUtil.FIRST_NAME_JIGNESH);
		assertEquals("Found user instance's last name must match with " +
				"user last name  provided to search by", 
				user.getLastName(), UserUtil.LAST_NAME_GOHEL);
		
	}
	
	@Ignore
	public void findUsersByRole() {
		printTestName("findUsersByRole");
		List<User> users = userUtil.findUsersByRole(Role.BORROWER);
		
		assertEquals("Count for the Users found by role must match with " +
				"test users saved having the role, provided to search by", 
				users.size(), UserUtil.BORROWER_ROLE_EXPECTED_RESULTS_COUNT);
	}
}
