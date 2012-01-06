package com.botreeconsulting.lms.hibernate.xml.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;

import com.botreeconsulting.lms.hibernate.xml.util.HibernateUtil;


public class TestBase {
	
	protected SessionFactory sessionFactory;
	
	@Before
	public void getSessionFactory() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
}
