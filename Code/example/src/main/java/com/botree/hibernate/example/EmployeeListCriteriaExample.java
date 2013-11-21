package com.botree.hibernate.example;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class EmployeeListCriteriaExample {
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
		
		//Create an instance of Criteria (programmatic way of writing database queries)
		Criteria c = session.createCriteria(Employee.class);
		List<Employee> list = c.list();
		for(Employee e : list) {
			System.out.println(e.toString());
		}
		
		System.out.println("====================================");
		//Criteria for a unique result
		c = session.createCriteria(Employee.class).add(Restrictions.eq("employeeId", 2));
		Employee e = (Employee) c.uniqueResult();
		System.out.println(e.toString());
		
		//Do not forget to close the session which will invalidate transaction
		session.close();
	}
}
