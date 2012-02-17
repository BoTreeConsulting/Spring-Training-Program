package com.botreeconsulting.springsecurity.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.botreeconsulting.springsecurity.dao.GenericDAO;

public class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	private static final Logger logger = LoggerFactory
			.getLogger(GenericDAOImpl.class);

	private Class<T> persistenceClass;

	@Autowired
	private SessionFactory sessionFactory;

	// Without this the persistenceClass instance would always be found null
	public GenericDAOImpl(final Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public ID create(T newInstance) {
		return (ID) sessionFactory.getCurrentSession().save(newInstance);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) sessionFactory.getCurrentSession().get(persistenceClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				persistenceClass);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T t) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				persistenceClass);
		Example example = Example.create(t);
		criteria.add(example);
		return criteria.list();
	}

	public void update(T transientObject) {
		sessionFactory.getCurrentSession().saveOrUpdate(transientObject);
	}

	public void delete(T persistentObject) {
		sessionFactory.getCurrentSession().delete(persistentObject);
	}

	public long countAll(Class<T> persistentObject) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = null;
		if (session != null) {
			criteria = session.createCriteria(persistentObject);
			criteria.setProjection(Projections.rowCount());
			return (Long) criteria.list().get(0);
		} else {
			logger.info("Hibernate Session instance found null");
		}
		return -1;
	}
}