package com.botreeconsulting.demo.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CascadeAuthorPersistDemoThree {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Book book = new Book();
		book.setTitle("Linchpin");
		book.setIsbn("1122997");

		Author author = new Author();
		author.setFirstName("Seth");
		author.setLastName("Godin");

		// Associate Author with Book.
		book.getAuthors().add(author);

		// Associate Book with Author
		//author.getBooks().add(book);

		Transaction transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
	}

}
