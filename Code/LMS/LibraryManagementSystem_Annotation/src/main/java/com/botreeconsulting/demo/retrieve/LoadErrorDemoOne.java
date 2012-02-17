package com.botreeconsulting.demo.retrieve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class LoadErrorDemoOne {
	
	public static void main(String[] args){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Author author = (Author)session.load(Author.class, 24L);
		session.close();
		
		author.setFirstName("Danny");		
		System.out.println("Author changed name " + author.getFirstName());
	}	
}
