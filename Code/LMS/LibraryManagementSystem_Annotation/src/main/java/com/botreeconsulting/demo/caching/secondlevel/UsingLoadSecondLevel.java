package com.botreeconsulting.demo.caching.secondlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class UsingLoadSecondLevel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Author authorOne = (Author)session.load(Author.class, 1L);
		System.out.println(authorOne.getFirstName());
		
		transaction.commit();
		session.close();
		
		Session sessionOne = sessionFactory.openSession();
		Transaction transactionOne = sessionOne.beginTransaction();
		
		Author authorTwo = (Author)sessionOne.load(Author.class, 1L);
		System.out.println(authorTwo.getFirstName());
				
		transactionOne.commit();
		sessionOne.close();
	}
}
