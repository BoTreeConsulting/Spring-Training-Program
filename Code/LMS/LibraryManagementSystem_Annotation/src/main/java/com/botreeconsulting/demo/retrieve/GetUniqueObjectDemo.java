package com.botreeconsulting.demo.retrieve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class GetUniqueObjectDemo {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Author authorOne = (Author)session.get(Author.class, 24L);
		transaction.commit();
		session.close();
		
		//authorOne is detached. Update Name
		authorOne.setFirstName("John");
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Author authorTwo = (Author)session.get(Author.class, 24L);
		authorTwo.setFirstName("Johnny");
		session.update(authorOne);
		session.update(authorTwo);
		transaction.commit();
		session.close();
		
	}
}
