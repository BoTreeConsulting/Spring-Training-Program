package com.botreeconsulting.demo.fetch;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class FetchDemoOne {
	public static void main(String[] args){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		/*Book book = new Book();
		book.setTitle("Test Book");
		book.setIsbn("123123123");*/
		
		Transaction transaction = session.beginTransaction();
		Author author = (Author)session.get(Author.class, 24L);
		System.out.println("Author Name : " + author.getFirstName());
		Set<Book> books = author.getBooks();
		System.out.println("No. of Books : " + books.size() );
		/*author.getBooks().add(book);
		session.persist(book);
		session.update(author);*/
		transaction.commit();
	}
}
