package com.botreeconsulting.demo.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CascadeAuthorPersistDemoTwo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Book book = new Book();
		book.setTitle("XXX");
		book.setIsbn("11224455999");

		Author author = new Author();
		author.setFirstName("Malcom2G");
		author.setLastName("GladwellX");
		
		//Associate Author with Book.
		author.getBooks().add(book);
		
		Transaction transaction = session.beginTransaction();
		session.save(author);
		transaction.commit();
	}

}
