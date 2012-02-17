package com.botreeconsulting.demo.hql;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Book;
import com.botreeconsulting.lms.util.HibernateUtil;

public class HQLDemoFive {
	//Using SELECT clause
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		String getAllAuthorsAndBooks = "select book from Author as author inner join author.books as book where book.title like 'Lin%'";
		Query query = session.createQuery(getAllAuthorsAndBooks);
		List<Book> books = query.list();
				
		for(Book book : books){
			System.out.println(book.getTitle());
		}		
	}
}
