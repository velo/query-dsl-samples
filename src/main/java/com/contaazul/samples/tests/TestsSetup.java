package com.contaazul.samples.tests;

import static com.google.common.collect.Lists.newArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.contaazul.samples.entity.Pessoa;

public abstract class TestsSetup {

	protected static EntityManager em;
	private static EntityTransaction transaction;

	@BeforeClass
	public static void beforeAll() {
		em = Persistence.createEntityManagerFactory("h2").createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		Pessoa p1 = new Pessoa("p1");
		em.persist(p1);
		em.persist(new Pessoa("p2"));
		em.persist(new Pessoa("p3"));
		em.persist(new Pessoa("p4"));
		em.persist(new Pessoa("p5"));
		em.persist(new Pessoa("p6"));
		em.persist(new Pessoa("p7"));
		em.persist(new Pessoa("p8"));
		em.persist(new Pessoa("p9"));
		Pessoa p10 = new Pessoa("p10");
		em.persist(p10);
		p1.setChildren(newArrayList(p10));
		em.merge(p1);
		t.commit();
		
		transaction = em.getTransaction();
		transaction.begin();
	}

	@AfterClass
	public static void afterAll() {
		transaction.commit();
		em.close();
		em.getEntityManagerFactory().close();
	}

}
