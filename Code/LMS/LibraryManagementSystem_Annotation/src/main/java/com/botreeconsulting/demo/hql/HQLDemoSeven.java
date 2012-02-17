package com.botreeconsulting.demo.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.util.HibernateUtil;

public class HQLDemoSeven {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		String allObjects = "from java.lang.Object";
		Query query = session.createQuery(allObjects);
		List<Object> objects = query.list();
		
		for(Object object : objects){
			System.out.println(object.toString());
		}
	}
}
