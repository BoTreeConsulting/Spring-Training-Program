package com.botreeconsulting.demo.retrieve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class LoadErrorDemoTwo {
	
	public static void main(String[] args){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();		
		Author author = (Author)session.load(Author.class, 99L);
		System.out.println("Author name " + author.getFirstName());		
	}	
}
