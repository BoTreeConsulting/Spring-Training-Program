package com.botreeconsulting.demo.persistent;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class SaveDemo {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Author author = new Author();
		author.setFirstName("Mahatama");
		author.setLastName("Gandhi");
		author.setAge(Integer.parseInt("60"));
		
		Book book = new Book();
		book.setTitle("My Experiments with Truth.");
		book.setIsbn("999999");

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Serializable authorId = session.save(author);		
		System.out.println("Author Primary Id : " + authorId);
		
		Serializable bookId = session.save(book);
		System.out.println("Book Primary Id : " + bookId);
		
		transaction.commit();		
	}
}
