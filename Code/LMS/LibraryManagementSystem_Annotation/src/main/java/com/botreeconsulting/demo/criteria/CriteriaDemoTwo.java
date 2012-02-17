package com.botreeconsulting.demo.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoTwo {
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria limitAuthors = session.createCriteria(Author.class);
		limitAuthors.setFirstResult(5);
		limitAuthors.setMaxResults(10);
		List<Author> authors = limitAuthors.list();
		
		for(Author author : authors){
			System.out.println(" Author : " + author.getId() + " - " + author.getFirstName());
		}
	}
}
