package com.botreeconsulting.lms.util;

import org.hibernate.Session;

import com.botreeconsulting.lms.model.Publication;

public class PublicationUtil extends EntityUtil<Publication, Long>{

	public PublicationUtil(Session session, Class<Publication> entityClass) {
		super(session, entityClass);
	}

}
