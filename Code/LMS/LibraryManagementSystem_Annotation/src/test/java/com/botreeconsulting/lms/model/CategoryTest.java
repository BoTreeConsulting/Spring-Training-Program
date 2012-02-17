package com.botreeconsulting.lms.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

import com.botreeconsulting.lms.util.CategoryUtil;

public class CategoryTest extends TestBase {

	private static final Logger logger = LoggerFactory.getLogger(CategoryTest.class);
	
	private List<Category> testCategories = CategoryUtil.getTestCategories();
	
	@Before
	public void addTestCategories() {
		
		try {
			Session session = openSession();
			
			CategoryUtil.addCategories(session, testCategories);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while adding categories: " + he.getMessage());
		}
	}
	
	@After
	public void deleteAllCategories() {
		
		try {
			Session session = openSession();
			
			CategoryUtil.deleteAllCategories(session);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while deleting all available categories: " + he.getMessage());
		}
	}
	
	@Test
	public void testAddCategory() {
		printTestName("testAddCategory");
		for (Category testCategory : testCategories) {
			assertNotNull("Persisted Category Id must not be null", testCategory.getId());
		}
	}
	
	@Test
	public void testUpdateCategoryNameHavingCode() {
		printTestName("testUpdateCategoryNameHavingCode");
		try {
			Session session = openSession();
			
			Category testCategory = testCategories.get(3);
			String categoryCode = testCategory.getCategoryCode();
			String updatedCategoryName = testCategory.getCategoryName() + "Updated";
			Category category = CategoryUtil.updateCategoryNameHavingCode(session, categoryCode, updatedCategoryName);
			
			assertNotNull("retrieved category must not be null", category);
			
			assertEquals("Retrieved persistent category instance's name " +
					"should be same as the name provided to update by",
					category.getCategoryName(), updatedCategoryName);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while adding categories: " + he.getMessage());
		}
	}
	
	@Test
	public void testFindCategoryById() {
		printTestName("testFindCategoryById");
		try {
			Session session = openSession();
			
			Long categoryId = testCategories.get(3).getId();
			Category category = CategoryUtil.findCategoryById(session, categoryId);
			
			assertNotNull("retrieved category must not be null", category);
			
			assertEquals("Retrieved persistent category instance's id " +
					"should be same as the id provided to search by",
					category.getId(), categoryId);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while adding categories: " + he.getMessage());
		}
	}
	
	@Test
	public void testFindCategoryByName() {
		printTestName("testFindCategoryByName");
		try {
			Session session = openSession();
			
			String categoryName = testCategories.get(0).getCategoryName();
			Category category = CategoryUtil.findCategoryByName(session, categoryName);
			
			assertNotNull("retrieved category must not be null", category);
			
			assertEquals("Retrieved persistent category instance's categoryName " +
					"should be same as the category name provided to search by",
					category.getCategoryName(), categoryName);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while adding categories: " + he.getMessage());
		}
	}
	
	@Test
	public void testFindCategoryByCode() {
		printTestName("testFindCategoryByCode");
		try {
			Session session = openSession();
			
			String categoryCode = testCategories.get(2).getCategoryCode();
			Category category = CategoryUtil.findCategoryByCode(session, categoryCode);
			
			assertNotNull("retrieved category must not be null", category);
			
			assertEquals("Retrieved persistent category instance's categoryCode " +
					"should be same as the category code provided to search by",
					category.getCategoryCode(), categoryCode);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while adding categories: " + he.getMessage());
		}
	}
	
	@Test
	public void testFindCategoryByCodeAndName() {
		printTestName("testFindCategoryByCodeAndName");
		try {
			Session session = openSession();
			
			Category tesCategory = testCategories.get(2);
			String categoryCode = tesCategory.getCategoryCode();
			String categoryName = tesCategory.getCategoryName();
			Category category = CategoryUtil.findCategoryByCodeAndName(session, categoryCode, categoryName);
			
			assertNotNull("retrieved category must not be null", category);
			
			assertEquals("Retrieved persistent category instance's categoryCode " +
					"should be same as the category code provided to search by",
					category.getCategoryCode(), categoryCode);
			
			assertEquals("Retrieved persistent category instance's categoryCode " +
					"should be same as the category code provided to search by",
					category.getCategoryName(), categoryName);
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while adding categories: " + he.getMessage());
		}
	}

	@Test
	public void testDeleteCategory() {
		printTestName("testDeleteCategory");
		try {
			Session session = openSession();
			
			CategoryUtil.deleteCategory(session, testCategories.get(1));
			
			session.close();
				
		} catch (HibernateException he) {
			logger.error("Exception occured while deleting all available categories: " + he.getMessage());
		}
	}
	
	private void printTestName(String testName) {
		if (logger.isInfoEnabled()) {
			logger.info("\n");
			logger.info(testName);
			logger.info("\n");
		}
	}
}
