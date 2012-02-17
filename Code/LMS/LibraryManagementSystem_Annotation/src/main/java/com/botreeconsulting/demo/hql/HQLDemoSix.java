package com.botreeconsulting.demo.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.util.HibernateUtil;

public class HQLDemoSix {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		String getAllAuthorsAndBooks = "select avg(author.age) from Author author";
		Query query = session.createQuery(getAllAuthorsAndBooks);
		System.out.println(query.list());
	}
}
