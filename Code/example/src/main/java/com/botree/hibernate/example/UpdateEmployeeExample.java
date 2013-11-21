package com.botree.hibernate.example;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateEmployeeExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create SessionFactory which is a Factory for Hibernate Sessions
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Get current session from Session Factory
		// Session is a Factory for hibernate Transactions
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// Query for a unique result
		Query q = session.createQuery("from Employee where employeeId = 2");
		Employee e = (Employee) q.uniqueResult();
		System.out.println(e.toString());
		
		//Update the Employee instance with appropriate property values
		e.setEmployeeName("Smart Employee");
		
		//Update the Employee instance in the Hibernate Session
		session.update(e);
		
		//Commit the transaction which will save the updated employee instance to the database
		session.getTransaction().commit();
	}

}
