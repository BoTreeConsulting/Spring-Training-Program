package com.botreeconsulting.demo.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class HQLDemoTwo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		String getAllAuthorsAndBooks = "from Author as author left outer join author.books as books";
		Query query = session.createQuery(getAllAuthorsAndBooks);
		List<Object> results = query.list();
		
		for(int i = 0; i < results.size(); i++){
			Object[] resultantObjects = (Object[]) results.get(i);
			Author author = (Author)resultantObjects[0];
			System.out.println(author.getFirstName() + " " + author.getLastName());
		}
	}
}
