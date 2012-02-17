package com.botreeconsulting.demo.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoSix {

	private static final String FIRST_NAME = "firstName";
	private static final String TITLE = "title";

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		//Using ASSOCIATIONS
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria limitAuthors = session.createCriteria(Author.class);
		limitAuthors.add(Restrictions.ilike(FIRST_NAME, "Mohan%"))
				.createCriteria("books")
				.add(Restrictions.ilike(TITLE, "%Truth%"));
		
		List<Author> authors = limitAuthors.list();

		for (Author author : authors) {
			System.out.println(" Author : " + author.getId() + " - "
					+ author.getFirstName());
		}
	}
}
