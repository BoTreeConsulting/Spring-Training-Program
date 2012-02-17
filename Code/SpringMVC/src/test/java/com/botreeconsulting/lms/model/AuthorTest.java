package com.botreeconsulting.lms.model;


import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.botreeconsulting.lms.util.AuthorUtil;

public class AuthorTest extends GenericTestBase<Author, Long> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AuthorTest.class);
	private List<Author> testAuthors = null;
	private AuthorUtil authorUtil = null;
	
	@Before
	public void addTestAuthors() {
		Session session = openSession();
	
		// Create AuthorUtil
		authorUtil = new AuthorUtil(session, Author.class);
		
		// Set EntityUtil to AuthorUtil
		setEntityUtil(authorUtil);
		
		// Get test authors
		testAuthors = AuthorUtil.getTestAuthors();
		
		// add test authors
		addTestEntities(testAuthors);
		
	}
	
	@After
	public void deleteAllAuthors() {
		deleteAllEntities();
		
		authorUtil.getSession().close();
	}
	
	@Test
	public void testAddAuthor() {
		printTestName("testAddAuthor");
		for (Author author : testAuthors) {
			assertNotNull("Persisted Author Id must not be null", author.getId());
		}
	}
	
	@Test
	public void testFindAuthorsByFirstName() {
		printTestName("testFindAuthorsByFirstName");
		String firstName = AuthorUtil.FIRST_NAME_SWAMI;
		List<Author> authors = authorUtil.findAuthorsByFirstName(firstName);
		assertEquals("Count for the Authors found by first name must match with " +
				"test authors saved having the first name provided to search by ", 
				authors.size(), AuthorUtil.FIRST_NAME_SWAMI_RESULTS_EXPECTED_COUNT);
	}
	
	@Test
	public void testFindAuthorsByLastName() {
		printTestName("testFindAuthorsByLastName");
		String lastName = AuthorUtil.LAST_NAME_SHARMA;
		List<Author> authors = authorUtil.findAuthorsByLastName(lastName);
		assertEquals("Count for the Authors found by last name must match with " +
				"test authors saved having the last name provided to search by ", 
				authors.size(), AuthorUtil.LAST_NAME_SHARMA_RESULTS_EXPECTED_COUNT);
	}
	
	@Test
	public void testFindAuthorByFirstAndLastName() {
		printTestName("testFindAuthorByFirstAndLastName");
		String firstName = AuthorUtil.FIRST_NAME_SWAMI;
		String lastName = AuthorUtil.LAST_NAME_SHARMA;
		Author author = authorUtil.findAuthorByFirstNameAndLastName(firstName, lastName);
		assertNull("Author instance found for provided first name and last name must be null", author);
	}
}
