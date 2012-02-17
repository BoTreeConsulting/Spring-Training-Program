package com.botreeconsulting.demo.modifypersistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class BasicUpdateDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
						
		Book book = (Book) session.get(Book.class, 10L);
		book.setIsbn("90909090");
		Transaction transaction = session.beginTransaction();
		session.update(book);
		transaction.commit();
	}
}
