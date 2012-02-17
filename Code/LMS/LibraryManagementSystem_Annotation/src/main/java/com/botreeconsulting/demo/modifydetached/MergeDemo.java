package com.botreeconsulting.demo.modifydetached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class MergeDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Author authorOne = (Author) session.get(Author.class, 24L);
		transaction.commit();
		session.close();

		// authorOne is detached. Update Name
		authorOne.setFirstName(null);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		//This is just to bring to notice that we are fetching the row again.
		//The assignment is not really required.
		Author authorTwo = (Author)session.get(Author.class, 24L);
		Author authorThree = (Author) session.merge(authorOne);
		//session.update(authorThree);
		
		transaction.commit();
		session.close();

	}
}
