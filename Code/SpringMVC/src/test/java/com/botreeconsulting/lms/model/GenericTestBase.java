package com.botreeconsulting.lms.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.botreeconsulting.lms.util.EntityUtil;
import com.botreeconsulting.lms.util.HibernateUtil;


public abstract class GenericTestBase<Entity, IdentifierType extends Serializable> {
	
	private static final Logger logger = LoggerFactory.getLogger(GenericTestBase.class);
	
	private SessionFactory sessionFactory;
	
	private EntityUtil<Entity, IdentifierType> entityUtil; 

	@Before
	public void getSessionFactory() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	/**
	 * 
	 * @param entityUtil
	 */
	public void setEntityUtil(EntityUtil<Entity, IdentifierType> entityUtil) {
		this.entityUtil = entityUtil;
	}
	
	/**
	 * 
	 * @param entities
	 */
	public void addTestEntities(List<Entity> entities) {
		try {
			for (Entity entity : entities) {
				entityUtil.addEntity(entity);
			}
		} catch (HibernateException he) {
			logger.error("Exception occured while adding entities: " + he.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void deleteAllEntities() {
		try {
			entityUtil.deleteAllEntities();
		} catch (HibernateException he) {
			logger.error("Exception occured while deleting all available entities: " + he.getMessage());
		}
	}
	/**
	 * 
	 * @param testName
	 */
	public void printTestName(String testName) {
		if (logger.isInfoEnabled()) {
			logger.info("\n");
			logger.info(testName);
			logger.info("\n");
		}
	}
}
