package com.botreeconsulting.lms.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.botreeconsulting.lms.model.Author;

public class AuthorUtil extends EntityUtil<Author, Long> {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorUtil.class);

	public static final int FIRST_NAME_SWAMI_RESULTS_EXPECTED_COUNT = 3;
	public static final int LAST_NAME_SHARMA_RESULTS_EXPECTED_COUNT = 1;
	public static final String FIRST_NAME_SWAMI = "Swami";
	public static final String LAST_NAME_SHARMA = "Sharma";
	public static final int FIRST_NAME_SWAMI_LAST_NAME_SHARMA_RESULTS_EXPECTED_COUNT = 0;
	
	private static final String[][] TEST_AUTHORS = {
		// Format -> {first name, last name}
		{"Stephen", "Covey"},
		{"Zig", "Ziglar"},
		{"Robin", "Sharma"},
		{"Swami", "Anubhavanand"},
		{"Swami", "Chinmayanand"},
		{"Swami", "SivanandSaraswati"},
	};
	
	public AuthorUtil(Session session, Class<Author> entityClass) {
		super(session, entityClass);
	}
	
	private static final String FIRST_NAME_PROPERTY = "firstName";
	private static final String LAST_NAME_PROPERTY = "lastName";
	
	/**
	 * 
	 * @param firstName the first name
	 * @param lastName the last name
	 * 
	 * @return the persistent {@link Author} instance having the specified 
	 * <code>firstName</code> and <code>lastName</code> or 
	 * NULL if the author could not found in the system
	 */
	public Author findAuthorByFirstNameAndLastName(String firstName, String lastName) {
		Criteria criteria = getCriteriaForEntity();
		
		boolean isFirstNameAvailable = StringUtil.isNotEmpty(firstName);
		boolean isLastNameAvailable = StringUtil.isNotEmpty(lastName);
		
		if (logger.isInfoEnabled()) {
			logger.info("First Name available? : " + isFirstNameAvailable);
			logger.info("Last Name available? : " + isLastNameAvailable);
		}
		Criterion firstNameCriterion = 
				isFirstNameAvailable ? Restrictions.eq(FIRST_NAME_PROPERTY, firstName) 
										: null;
		
		Criterion lastNameCriterion = 
				isLastNameAvailable ? Restrictions.eq(LAST_NAME_PROPERTY, lastName) 
										: null;

		if (isFirstNameAvailable && isLastNameAvailable) {
			criteria.add(Restrictions.and(firstNameCriterion, lastNameCriterion));
		} 
		
		return (Author) criteria.uniqueResult();
	}
	
	/**
	 * 
	 * @param firstName the first name
	 * @return a {@link List} of the persistent {@link Author} instances having
	 *  the specified <code>firstName</code> or an empty list if the authors
	 *  with specified <code>firstName</code> are not available in the system
	 *  or the specified <code>firstName</code> is found null/empty
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Author> findAuthorsByFirstName(String firstName) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(firstName)) {
			criteria.add(Restrictions.eq(FIRST_NAME_PROPERTY, firstName));
			return criteria.list();
		} 
		
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @param lastName the last name
	 * @return a {@link List} of the persistent {@link Author} instances having
	 *  the specified <code>lastName</code> or an empty list if the authors
	 *  with specified <code>lastName</code> are not available in the system
	 *  or the specified <code>lastName</code> is found null/empty
	 */
	@SuppressWarnings("unchecked")
	public List<Author> findAuthorsByLastName(String lastName) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(lastName)) {
			criteria.add(Restrictions.eq(LAST_NAME_PROPERTY, lastName));
			return criteria.list();
		} 
		
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @return
	 */
	public static final List<Author> getTestAuthors() {
		List<Author> testAuthors = new ArrayList<Author>(TEST_AUTHORS.length);
		
		for (String[] testAuthor : TEST_AUTHORS) {
			testAuthors.add(getTestAuthor(testAuthor[0], testAuthor[1]));
		}
		return testAuthors;
	}
	
	private static Author getTestAuthor(String firstName, String lastName) {
		return new Author(firstName, lastName);
	}
	

}
