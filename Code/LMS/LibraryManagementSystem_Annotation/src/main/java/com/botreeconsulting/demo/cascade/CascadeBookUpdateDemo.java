package com.botreeconsulting.demo.cascade;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CascadeBookUpdateDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//In the Book class, we see that there is a CascaseType.SAVE_UPDATE
		//This means that we do not need to update the associating Author separately.
		Book book = (Book) session.get(Book.class, 1L);		
		Set<Author> authors = book.getAuthors();

		Author authorX = new Author();
		authorX.setFirstName("Mohandas");
		authorX.setLastName("Gandhi");
		
		//Associate new Author with an existing book.
		authors.add(authorX);
		
		Transaction transaction = session.beginTransaction();
		session.update(book);
		transaction.commit();
	}

}
