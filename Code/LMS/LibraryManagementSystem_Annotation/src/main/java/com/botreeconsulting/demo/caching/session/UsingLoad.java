package com.botreeconsulting.demo.caching.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class UsingLoad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Author authorOne = (Author)session.load(Author.class, 1L);
		System.out.println(authorOne.getFirstName());
		
		Author authorTwo = (Author)session.load(Author.class, 1L);
		System.out.println(authorTwo.getFirstName());
				
		transaction.commit();
		session.close();
	}
}
