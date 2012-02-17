package com.botreeconsulting.lms.hibernate.xml.model.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.botreeconsulting.lms.hibernate.xml.model.Publisher;
import com.botreeconsulting.lms.hibernate.xml.util.EntityUtil;

public class PublisherUtil extends EntityUtil<Publisher, Long> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(PublisherUtil.class);
	
	public static final String KEYWORD_DIV = "div";
	public static final int KEYWORD_DIV_RESULTS_EXPECTED_COUNT = 1;
	
	private static final String[][] TEST_PUBLISHERS = {
		// Format -> {name, url, address, contactNumber}
		{"The Divine Life Society Publication", "www.sivanandonline.org", "Uttarakhand, Himalayas", "123456"},
		{"Hind Pocket Books", "www.atfullcircle.com", "New Delhi", "789123"},
		{"Oreilly Books", "www.oreilly.com", "USA", "475621"}
	};

	public PublisherUtil(Session session, Class<Publisher> entityClass) {
		super(session, entityClass);
	}

	private static final String NAME_PROPERTY = "name";
	
	/**
	 * 
	 * @param name the name of publisher
	 * 
	 * @return the {@link Publisher} instance having the specified 
	 * <code>name</code> or NULL if the publisher could not be found in the 
	 * system for the specified <code>name</code> 
	 */
	public Publisher findPublisherByName(String name) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(name)) {
			criteria.add(Restrictions.eq(NAME_PROPERTY, name));
			return (Publisher) criteria.uniqueResult();
		} 
		return null;
	}
	
	/**
	 * 
	 * @param keyword the keyword
	 * 
	 * @return a {@link List} holding {@link Publisher} instances having the
	 * specified <code>keyword</code> in its name or an empty list if no publishers
	 * could be found into the system having the specified <code>keyword</code>
	 *  in its name. 
	 */
	@SuppressWarnings("unchecked")
	public List<Publisher> findPublishersByKeyword(String keyword) {
		Criteria criteria = getCriteriaForEntity();
		
		if (StringUtil.isNotEmpty(keyword)) {
			criteria.add(Restrictions.like(NAME_PROPERTY, keyword, MatchMode.ANYWHERE));
			return criteria.list();
		}
		
		return Collections.emptyList();
	}
	
	/**
	 * 
	 * @return
	 */
	public static final List<Publisher> getTestPublishers() {
		List<Publisher> testPublishers = new ArrayList<Publisher>(TEST_PUBLISHERS.length);
		
		for (String[] testPublisher : TEST_PUBLISHERS) {
			testPublishers.add(
					getTestPublisher(testPublisher[0], 
							testPublisher[1], 
							testPublisher[2], 
							testPublisher[3]));
					
		}
		return testPublishers;
	}
	
	private static Publisher getTestPublisher(
			String name, String url, String address, String contactNumber) {
		
		Publisher publisher = new Publisher();
		publisher.setName(name);
		publisher.setUrl(url);
		publisher.setAddress(address);
		publisher.setContactNumber(contactNumber);
		
		return publisher;
	}
}
