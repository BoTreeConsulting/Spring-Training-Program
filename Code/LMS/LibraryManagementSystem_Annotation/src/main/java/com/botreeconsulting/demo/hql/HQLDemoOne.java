package com.botreeconsulting.demo.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class HQLDemoOne {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String getAllAuthors = "from Author";		
		Query query = session.createQuery(getAllAuthors);
		List<Author> authors = query.list();
		System.out.println("Total number of Authors are " + authors.size());
	}
}
