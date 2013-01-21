package com.contaazul.samples.factory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;

public class JPQLQueryFactory {

	@PersistenceContext(unitName = "Admin")
	private EntityManager entityManager;

	public JPQLQuery from(EntityPath<?>...args) {
		return new JPAQuery(entityManager).from(args);
	}

}
