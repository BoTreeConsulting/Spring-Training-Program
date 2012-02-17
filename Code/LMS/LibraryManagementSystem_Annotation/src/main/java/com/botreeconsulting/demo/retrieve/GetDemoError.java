package com.botreeconsulting.demo.retrieve;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class GetDemoError {
	public static void main(String[] args){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Author author = (Author)session.get(Author.class, 99L);
		System.out.println("Author First Name " + author.getFirstName());
		transaction.commit();
	}	
}
