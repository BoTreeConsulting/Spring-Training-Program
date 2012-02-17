package com.botreeconsulting.demo.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CascadeAuthorPersistDemoOne {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Book book = new Book();
		book.setTitle("Blink");
		book.setIsbn("112233");

		Author author = new Author();
		author.setFirstName("Malcom");
		author.setLastName("Gladwell");
		
		//Associate Book with Author
		author.getBooks().add(book);
		
		Transaction transaction = session.beginTransaction();
		session.persist(author);
		transaction.commit();
	}

}
