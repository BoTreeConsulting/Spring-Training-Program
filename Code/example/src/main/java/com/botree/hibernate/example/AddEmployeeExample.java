package com.botree.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddEmployeeExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create SessionFactory which is a Factory for Hibernate Sessions
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//Get current session from Session Factory
		//Session is a Factory for hibernate Transactions
		Session session = factory.getCurrentSession();

		//Create as many records of Employees as required
		Employee emp = new Employee();
		emp.setEmployeeName("employee1");

		Employee emp2 = new Employee();
		emp2.setEmployeeName("employee2");

		Employee emp3 = new Employee();
		emp3.setEmployeeName("employee3");

		//Begin Transaction
		Transaction tx = session.beginTransaction();
		session.save(emp);
		session.save(emp2);
		session.save(emp3);
		//Committing transaction will close the session as well. so no need to close the session explicitly.
		tx.commit();
		System.out.println(session.isOpen());
	}

}
