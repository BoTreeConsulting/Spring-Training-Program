package com.botreeconsulting.demo.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoEight {
	//PROJECTION : Row Count
	private static final String FIRST_NAME = "firstName";
	
	public static void main(String args[]) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria limitAuthors = session.createCriteria(Author.class);
		limitAuthors.add(Restrictions.ilike(FIRST_NAME, "M%"));
						//.setProjection(Projections.rowCount());

		Long rowCount = (Long)limitAuthors.setProjection(Projections.rowCount()).list().get(0);

		System.out.println("Size of results : " + rowCount);
		
	}
}
