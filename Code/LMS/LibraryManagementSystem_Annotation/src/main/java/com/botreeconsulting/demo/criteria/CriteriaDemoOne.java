package com.botreeconsulting.demo.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoOne {
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria allAuthorsCriteria = session.createCriteria(Author.class);
		List<Author> authors = allAuthorsCriteria.list();
		System.out.println("authors Size : " + authors.size());
	}
}