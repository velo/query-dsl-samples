package com.contaazul.samples.sample05;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.contaazul.samples.entity.Pessoa;
import com.contaazul.samples.entity.QPessoa;
import com.contaazul.samples.tests.TestsSetup;
import com.mysema.query.jpa.impl.JPAQuery;

public class Projection extends TestsSetup {

	@Test
	public void jpaHql() {
		Query q = em.createQuery("SELECT new Pessoa(p.name) FROM Pessoa p");
		//esqueci de apagar q.setParameter("name", "%");
		@SuppressWarnings("unchecked")
		List<Pessoa> people = q.getResultList();

		assertThat(people, hasSize(10));
		for (Pessoa pessoa : people) {
			assertThat(pessoa.getId(), nullValue());
		}
	}

	@Test
	public void querydsl() {
		JPAQuery q = new JPAQuery(em);
		QPessoa p = QPessoa.pessoa;

		List<Pessoa> people = q.from(p).list(QPessoa.create(p.name));

		assertThat(people, hasSize(10));
		for (Pessoa pessoa : people) {
			assertThat(pessoa.getId(), nullValue());
		}
	}
}
