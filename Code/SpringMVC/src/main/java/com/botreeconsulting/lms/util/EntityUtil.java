package com.botreeconsulting.lms.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EntityUtil<Entity, IdentifierType extends Serializable> {
	private static final Logger logger = LoggerFactory.getLogger(EntityUtil.class);
	
	private Session session;
	private Class<?> clazz;
	
	/**
	 * 
	 * @param session the current Hibernate {@link Session} instance
	 * @param entityClass the {@link Class} instance of the entity type 
	 * represented by parameterized type <code>Entity</code> of this class.
	 */
	public EntityUtil(Session session, Class<Entity> entityClass) {
		this.session = session;
		this.clazz = entityClass;
	}
	
	/**
	 * 
	 * @return the current Hibernate {@link Session} instance
	 */
	public Session getSession() {
		return session;
	}
	
	/**
	 * 
	 * @param transientEntity a transient entity to add to the system
	 * 
	 * @return the identifier assigned to the specified <code>transientEntity</code>
	 * after persisting it.
	 */
	public Serializable addEntity(Entity transientEntity) {
		Transaction transaction = session.beginTransaction();
		Serializable id = (Serializable) session.save(transientEntity);
		transaction.commit();
		return id;
	}
	
	/**
	 * 
	 * @param persistentEntity the persistent entity instance having its state 
	 * updated but not yet committed
	 * 
	 * @return the updated persistent entity instance
	 */
	public Entity updateEntity(Entity persistentEntity) {
		Transaction transaction = session.beginTransaction();
		session.merge(persistentEntity);
		transaction.commit();
		return persistentEntity;
	}
	
	/**
	 * 
	 * @param id the identifier of the persistent entity
	 * 
	 * @return the persistent entity having the specified <code>id</code>
	 */
	@SuppressWarnings("unchecked")
	public Entity findEntityById(IdentifierType id) {
		return (Entity) session.get(clazz, id);
	}
	
	/**
	 * 
	 * @param persistentEntity the persistent entity to remove from the system
	 */
	public void deleteEntity(Entity persistentEntity) {
		Transaction transaction = session.beginTransaction();
		session.delete(persistentEntity);
		transaction.commit();
	}
	
	/**
	 * 
	 * @param id the identifier of the persistent entity to remove from the system
	 */
	public void deleteEntityById(IdentifierType id) {
		Entity entity = findEntityById(id);
		Transaction transaction = session.beginTransaction();
		session.delete(entity);
		transaction.commit();
	}
	
	/**
	 * Removes all the persistent instances of the entity type represented by
	 * parameterized type <code>Entity</code> of this class.
	 */
	public void deleteAllEntities() {
		Criteria criteria = getCriteriaForEntity();
		@SuppressWarnings("unchecked")
		List<Entity> persistentEntities = criteria.list();
		if(!persistentEntities.isEmpty()) {
			for (Entity entity : persistentEntities) {
				deleteEntity(entity);
			}	
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("No entities found to delete");
			}
		}
	}
	
	/**
	 * 
	 * @return the {@link Criteria} instance for the entity type represented by
	 * parameterized type <code>Entity</code> of this class. 
	 */
	public Criteria getCriteriaForEntity() {
		Criteria criteria = session.createCriteria(clazz);
		return criteria;
	}
	
}
