package com.botree.hibernate.example;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateExample {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Employee emp = new Employee();
		emp.setEmployeeName("employee1");
		
		Employee emp2 = new Employee();
		emp2.setEmployeeName("employee2");
		
		Employee emp3 = new Employee();
		emp3.setEmployeeName("employee3");
		
		Transaction tx = session.beginTransaction();
		session.save(emp);
		session.save(emp2);
		session.save(emp3);
		tx.commit();
		
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Employee where employeeId = 2");
		
		Employee e = (Employee) q.uniqueResult();
		
		System.out.println(e.toString());
		//List<Employee> list = q.list();
		
/*		for(Employee e : list) {
			System.out.println(e.toString());
		}
*/
		e.setEmployeeName("employee4");
		session.update(e);
		//session.delete(e);
		session.getTransaction().commit();
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println(criteria.list());
		session.close();
	}
}
