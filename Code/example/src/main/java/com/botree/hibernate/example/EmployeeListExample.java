package com.botree.hibernate.example;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeListExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create SessionFactory which is a Factory for Hibernate Sessions
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//Get current session from Session Factory
		//Session is a Factory for hibernate Transactions
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		//Create an instance of Hibernate Query (HQL representation)
		Query q = session.createQuery("from Employee");
		List<Employee> list = q.list();
		for(Employee e : list) {
			System.out.println(e.toString());
		}
		
		System.out.println("====================================");
		//Query for a unique result
		q = session.createQuery("from Employee where employeeId = 2");
		Employee e = (Employee) q.uniqueResult();
		System.out.println(e.toString());
		
		//Do not forget to close the session which will invalidate transaction
		session.close();
	}
}
