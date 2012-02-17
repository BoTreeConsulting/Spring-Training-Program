package com.botreeconsulting.demo.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.botreeconsulting.lms.model.Author;
import com.botreeconsulting.lms.util.HibernateUtil;

public class CriteriaDemoNine {
	// PROJECTIONS
	private static final String AGE = "age";

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria authors = session.createCriteria(Author.class);
		authors.setProjection(
				Projections.projectionList()
						.add(Projections.property("firstName"))
						.add(Projections.countDistinct("firstName"), "rowCount")
						.add(Projections.avg(AGE), "averageAge")
						.add(Projections.max(AGE), "maxAge"))
				.setResultTransformer(
					Transformers.aliasToBean(ProjectionValues.class));

		List<ProjectionValues> projectionValuesList = authors.list();

		for (ProjectionValues projectionValues : projectionValuesList) {
			System.out.println("The values are : " + "Row Count - "
					+ projectionValues.getRowCount() + ", Average Age - "
					+ projectionValues.getAverageAge() + ", Max Age - "
					+ projectionValues.getMaxAge());
		}
	}
}
