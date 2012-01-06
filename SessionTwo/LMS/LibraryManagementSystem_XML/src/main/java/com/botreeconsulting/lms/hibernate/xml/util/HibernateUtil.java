package com.botreeconsulting.lms.hibernate.xml.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the session factory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();	
		} catch (HibernateException he) { // a runtime exception
			System.out.println("SessionFactory creation failed." + he);
			throw new ExceptionInInitializerError(he);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
