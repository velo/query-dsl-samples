package com.contaazul.samples.sample02;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.contaazul.samples.entity.Pessoa;
import com.contaazul.samples.entity.QPessoa;
import com.contaazul.samples.tests.TestsSetup;
import com.mysema.query.jpa.impl.JPAQuery;

public class Conditional extends TestsSetup {

	private int randomNumber;

	@Before
	public void setup() {
		randomNumber = 42;
	}

	@Test
	public void jpaHql() {
		String hql = "SELECT p FROM Pessoa p";
		if (randomNumber > 10)
			hql += /*esqueci o espaco*/" WHERE p.name LIKE :name";

		Query q = em.createQuery(hql);
		q.setParameter("name", "%");
		@SuppressWarnings("unchecked")
		List<Pessoa> people = q.getResultList();

		assertThat(people, hasSize(10));
	}

	@Test
	public void querydsl() {
		JPAQuery q = new JPAQuery(em);
		QPessoa p = QPessoa.pessoa;

		q.from(p);
		if (randomNumber > 10)
			q.where(p.name.like("%"));
		List<Pessoa> people = q.list(p);

		assertThat(people, hasSize(10));
	}
}
