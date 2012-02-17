package com.botreeconsulting.demo.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoTen {
	// PROJECTIONS
	private static final String AGE = "age";

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Author.class).add(Restrictions.eq(AGE, 50));
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Author> authors = detachedCriteria.getExecutableCriteria(session).list();
		
		for(Author author : authors){
			System.out.println("Author : " + author.getFirstName() + " " + author.getLastName());
		}
	}
}
