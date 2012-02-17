package com.botreeconsulting.lms.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.botreeconsulting.lms.model.Category;

// Note: This class is not a generic version for working with Category 
public class CategoryUtil {
	private static final Logger logger = LoggerFactory.getLogger(CategoryUtil.class);
	
	private static final String[][] TEST_CATEGORIES = {
		{"MATH", "Mathematics"},
		{"ART", "Arts"},
		{"CS", "Computer Science"},
		{"COOK", "Cooking"},
		{"SPTL", "Spiritual"},
	};
	
	/**
	 * 
	 * @param session
	 * @param categories
	 */
	public static final void addCategories(Session session, List<Category> categories) {
		for (Category testCategory : categories) {
			CategoryUtil.addCategory(session, testCategory);	
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param category
	 */
	public static final void addCategory(Session session, Category category) {
		Transaction transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
	}
	
	/**
	 * 
	 * @param session
	 * @param id
	 * 
	 * @return the persistent {@link Category} instance having the specified 
	 * <code>id</code> or NULL if the specified 
	 * <code>id</code> is found null/empty
	 */
	public static final Category findCategoryById(Session session, Long id) {
		if (id != null) {
			// Note: Here session.get(Category.class, id) could also be used.
			// to return the persistent Category instance having the specified
			// id.
			Criteria criteria = getCriteriaForCategory(session);
			criteria.add(Restrictions.idEq(id));
			
			return (Category) criteria.uniqueResult();
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("Could not find category by id.Id passed found null/empty");
			}
		}
		return null;
	}
	
	private static final String CATEGORY_CODE_PROPERTY = "categoryCode";
	private static final String CATEGORY_NAME_PROPERTY = "categoryName";
	
	/**
	 * 
	 * @param session
	 * @param categoryCode the category code
	 * @param updatedCategoryName the category name to update the current category name to.
	 *  
	 * @return the updated persistent {@link Category} instance or null if
	 * the persistent {@link Category} instance could not be found having the
	 * specified <code>categoryCode</code> 
	 */
	public static final Category updateCategoryNameHavingCode(
			Session session, String categoryCode, String updatedCategoryName) {
		
		Category category =  findCategoryByCode(session, categoryCode);
		
		if (category != null) {
			category.setCategoryName(updatedCategoryName);
			Transaction transaction = session.beginTransaction();
			category = (Category) session.merge(category);
			transaction.commit();
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("Could not update the name of the category having" +
						" code [" + categoryCode + "].Category instance found " +
							"to be null for the supplied code");
			}
		}
		return category;
	}
			
	/**
	 * 
	 * @param session
	 * @param categoryCode the category code
	 * @param categoryName the category name
	 * 
	 * @return the persistent {@link Category} instance having the specified 
	 * category code and/or category name based on the values found 
	 * or NULL if the category could not found in the system
	 */
	public static final Category findCategoryByCodeAndName(
			Session session, String categoryCode, String categoryName) {
		Criteria criteria = getCriteriaForCategory(session);
		
		boolean isCategoryNameAvailable = StringUtil.isNotEmpty(categoryName);
		boolean isCategoryCodeAvailable = StringUtil.isNotEmpty(categoryCode);
		
		if (logger.isInfoEnabled()) {
			logger.info("Category Name available? : " + isCategoryNameAvailable);
			logger.info("Category Code available? : " + isCategoryCodeAvailable);
		}
		Criterion categoryNameCriterion = 
				isCategoryNameAvailable ? Restrictions.eq(CATEGORY_NAME_PROPERTY, categoryName) 
										: null;
		
		Criterion categoryCodeCriterion = 
				isCategoryCodeAvailable ? Restrictions.eq(CATEGORY_CODE_PROPERTY, categoryCode) 
										: null;

		if (isCategoryNameAvailable && isCategoryCodeAvailable) {
			criteria.add(Restrictions.and(categoryNameCriterion, categoryCodeCriterion));
		} else {
			
			if (isCategoryNameAvailable) {
				criteria.add(categoryNameCriterion);	
			}
			
			if (isCategoryCodeAvailable) {
				criteria.add(categoryCodeCriterion);
			}
		} 
		
		return (Category) criteria.uniqueResult();
	}
	
	/**
	 * Note: This method assumes unique category names are allowed to enter into system.
	 * 
	 * @param session
	 * @param categoryName the category name
	 * 
	 * @return the persistent {@link Category} instance having the specified 
	 * <code>categoryName</code> or NULL if the specified 
	 * <code>categoryName</code> is found null/empty
	 * 
	 * @see #findCategoryByCodeAndName(Session, String, String, int)
	 */
	public static final Category findCategoryByName(Session session, String categoryName) {
		return findCategoryByCodeAndName(session, null, categoryName);
	}
	
	/**
	 * Note: This method assumes unique category codes are allowed to enter into system.
	 * 
	 * @param session
	 * @param categoryCode the category code
	 * 
	 * @return the persistent {@link Category} instance having the specified 
	 * <code>categoryCode</code> or NULL if the specified 
	 * <code>categoryCode</code> is found null/empty
	 * 
	 * @see #findCategoryByCodeAndName(Session, String, String, int)
	 */
	public static final Category findCategoryByCode(Session session, String categoryCode) {
		return findCategoryByCodeAndName(session, categoryCode, null);
	}
	
	/**
	 * 
	 * @param session
	 * @param category
	 */
	public static final void deleteCategory(Session session, Category category) {
		Transaction transaction = session.beginTransaction();
		session.delete(category);
		transaction.commit();
	}
	
	/**
	 * 
	 * @param session
	 */
	public static final void deleteAllCategories(Session session) {
		Criteria criteria = getCriteriaForCategory(session);
		@SuppressWarnings("unchecked")
		List<Category> persistentCategories = criteria.list();
		if(!persistentCategories.isEmpty()) {
			for (Category category : persistentCategories) {
				deleteCategory(session, category);
			}	
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("No categories found");
			}
		}
	}

	private static Criteria getCriteriaForCategory(Session session) {
		Criteria criteria = session.createCriteria(Category.class);
		return criteria;
	}
	/**
	 * 
	 * @return
	 */
	public static final List<Category> getTestCategories() {
		List<Category> testCategories = new ArrayList<Category>(TEST_CATEGORIES.length);
		
		for (String[] testCategory : TEST_CATEGORIES) {
			testCategories.add(getTestCategory(testCategory[0], testCategory[1]));
		}
		return testCategories;
	}
	
	private static Category getTestCategory(String categoryCode, String categoryName) {
		return new Category(categoryCode, categoryName);
	}
}
