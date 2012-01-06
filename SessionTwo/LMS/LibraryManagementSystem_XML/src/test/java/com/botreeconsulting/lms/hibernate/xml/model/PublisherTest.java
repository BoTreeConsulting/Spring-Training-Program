package com.botreeconsulting.lms.hibernate.xml.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.botreeconsulting.lms.hibernate.xml.model.Publisher;
import com.botreeconsulting.lms.hibernate.xml.model.util.PublisherUtil;

public class PublisherTest extends GenericTestBase<Publisher, Long> {

	private List<Publisher> testPublishers = null;
	private PublisherUtil publisherUtil = null;
	
	@Before
	public void addTestPublishers() {
		Session session = openSession();
		
		// Create PublisherUtil
		publisherUtil = new PublisherUtil(session, Publisher.class);
		
		// Set EntityUtil to PublisherUtil
		setEntityUtil(publisherUtil);
		
		// Get test publishers
		testPublishers = PublisherUtil.getTestPublishers();
		
		// add test publishers
		addTestEntities(testPublishers);
		
	}
	
	@After
	public void deleteAllPublishers() {
		deleteAllEntities();
		
		publisherUtil.getSession().close();
	}
	
	@Test
	public void testAddPublisher() {
		printTestName("testAddPublisher");
		for (Publisher publisher : testPublishers) {
			assertNotNull("Persisted Publisher Id must not be null", publisher.getId());
		}
	}
	
	@Test
	public void testFindPublisherByName() {
		printTestName("testFindPublisherByName");
		String publisherName = testPublishers.get(1).getName();
		Publisher publisher = publisherUtil.findPublisherByName(publisherName);
		
		assertNotNull("Publisher found should not be null", publisher);
		assertEquals("Found publisher instance's name must match with " +
				"publisher name provided to search by", 
				publisherName, publisher.getName());
	}
	
	@Test
	public void testFindPublishersByKeyword() {
		printTestName("testFindPublishersByKeyword");
		List<Publisher> publishers = publisherUtil.findPublishersByKeyword(PublisherUtil.KEYWORD_DIV);
		
		assertEquals("Count for the Publishers found by keyword name must match with " +
				"test publishers saved having the keyword, provided to search by, in its name ", 
				publishers.size(), PublisherUtil.KEYWORD_DIV_RESULTS_EXPECTED_COUNT);
	}
	
	
}
