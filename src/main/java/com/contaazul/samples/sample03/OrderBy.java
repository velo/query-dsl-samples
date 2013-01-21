package com.contaazul.samples.sample03;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.contaazul.samples.entity.Pessoa;
import com.contaazul.samples.entity.QPessoa;
import com.contaazul.samples.tests.TestsSetup;
import com.mysema.query.jpa.impl.JPAQuery;

public class OrderBy extends TestsSetup {

	@Test
	public void jpaHql() {
		Query q = em.createQuery("SELECT p FROM Pessoa p ORDER BY p.name ASC, p.id DESC" /* like p.name */);
		@SuppressWarnings("unchecked")
		List<Pessoa> people = q.getResultList();

		assertThat(people, hasSize(10));
	}

	@Test
	public void querydsl() {
		JPAQuery q = new JPAQuery(em);
		QPessoa p = QPessoa.pessoa;

		List<Pessoa> people = q.from(p).orderBy(p.name.asc(), p.id.desc()).list(p);

		assertThat(people, hasSize(10));
	}
}
