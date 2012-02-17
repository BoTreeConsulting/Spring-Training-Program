package com.botreeconsulting.lms.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the session factory
			// Similar to the Configuration object but handles EJB3 and 
			// Hibernate specific annotations as a metadata facility
			return new AnnotationConfiguration().configure().buildSessionFactory();	
		} catch (HibernateException he) { // a runtime exception
			System.out.println("SessionFactory creation failed." + he);
			throw new ExceptionInInitializerError(he);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
