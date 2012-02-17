package com.botreeconsulting.demo.persistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class PersistDemo {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Author author = new Author();
		author.setFirstName("Dan");
		author.setLastName("Brown");
		author.setAge(Integer.parseInt("50"));

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(author);
		transaction.commit();		
	}
}
