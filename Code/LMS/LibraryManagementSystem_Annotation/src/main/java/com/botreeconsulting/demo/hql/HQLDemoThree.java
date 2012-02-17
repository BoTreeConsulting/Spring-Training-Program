package com.botreeconsulting.demo.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class HQLDemoThree {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		String getAllAuthorsAndBooks = "from Author as author inner join fetch author.books";
		Query query = session.createQuery(getAllAuthorsAndBooks);
		List<Author> authors = query.list();
		
		for(Author author : authors){			
			System.out.println(author.getId() + " " + author.getFirstName() + " " + author.getLastName());
		}
	}
}
