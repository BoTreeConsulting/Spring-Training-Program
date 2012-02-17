package com.botreeconsulting.demo.caching.session;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class UsingQuery {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Author a where a.id = 1");

		Iterator it = query.list().iterator();
		while (it.hasNext()) {
			Author author = (Author) it.next();
			System.out.println(author.getFirstName());
		}
		query = session.createQuery("from Author a where a.id = 1");
		it = query.list().iterator();
		while (it.hasNext()) {
			Author author = (Author) it.next();
			System.out.println(author.getFirstName());
		}
		transaction.commit();
		session.close();
	}
}
