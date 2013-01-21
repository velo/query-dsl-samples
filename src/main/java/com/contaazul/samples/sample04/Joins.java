package com.contaazul.samples.sample04;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.contaazul.samples.entity.Pessoa;
import com.contaazul.samples.entity.QPessoa;
import com.contaazul.samples.tests.TestsSetup;
import com.mysema.query.jpa.impl.JPAQuery;

public class Joins extends TestsSetup {

	@Test
	public void jpaHql() {
		Query q = em.createQuery("SELECT p FROM Pessoa p inner join p.children as c " +
				"WHERE c.name LIKE :name");
		q.setParameter("name", "%");
		@SuppressWarnings("unchecked")
		List<Pessoa> people = q.getResultList();

		assertThat(people, hasSize(1));
	}

	@Test
	public void querydsl() {
		JPAQuery q = new JPAQuery(em);
		QPessoa p = QPessoa.pessoa;
		QPessoa c = new QPessoa("child");

		List<Pessoa> people = q.from(p, c).
				where(c.name.like("%")).list(p);

		assertThat(people, hasSize(1));
	}
}
