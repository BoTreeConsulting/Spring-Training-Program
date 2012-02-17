package com.botreeconsulting.demo.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoSeven {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		Book bookExample = new Book();
		bookExample.setTitle("Linc%");

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria bookCriteria = session.createCriteria(Book.class);
		bookCriteria.add(Example.create(bookExample));
		
		List<Book> books = bookCriteria.list();
		
		System.out.println("Book Title : " + books.get(0).getTitle());
		
	}
}
