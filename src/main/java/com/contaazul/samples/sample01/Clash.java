package com.contaazul.samples.sample01;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.contaazul.samples.entity.Pessoa;
import com.contaazul.samples.entity.Pessoa_;
import com.contaazul.samples.entity.QPessoa;
import com.contaazul.samples.tests.TestsSetup;
import com.mysema.query.jpa.impl.JPAQuery;

public class Clash extends TestsSetup {

	@Test
	public void jpaHql() {
		Query q = em.createQuery("SELECT p FROM Pessoa p WHERE p.name LIKE :name");
		q.setParameter("name", "%");
		@SuppressWarnings("unchecked")
		List<Pessoa> people = q.getResultList();

		assertThat(people, hasSize(10));
	}

	@Test
	public void jpaCriteria() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = criteriaBuilder.createQuery(Pessoa.class);
		Root<Pessoa> from = criteriaQuery.from(Pessoa.class);
		Predicate predicate2 = criteriaBuilder.like(from.<String> get("name"), "%");
		criteriaQuery.where(criteriaBuilder.and(predicate2));

		CriteriaQuery<Pessoa> select = criteriaQuery.select(from);
		TypedQuery<Pessoa> typedQuery = em.createQuery(select);
		List<Pessoa> people = typedQuery.getResultList();

		assertThat(people, hasSize(10));
	}

	@Test
	public void jpaCriteriaCodeGen() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = criteriaBuilder.createQuery(Pessoa.class);
		Root<Pessoa> from = criteriaQuery.from(Pessoa.class);
		Predicate predicate2 = criteriaBuilder.like(from.get(Pessoa_.name), "%");
		criteriaQuery.where(criteriaBuilder.and(predicate2));

		CriteriaQuery<Pessoa> select = criteriaQuery.select(from);
		TypedQuery<Pessoa> typedQuery = em.createQuery(select);
		List<Pessoa> people = typedQuery.getResultList();

		assertThat(people, hasSize(10));
	}

	@Test
	public void querydsl() {
		JPAQuery q = new JPAQuery(em);
		QPessoa p = QPessoa.pessoa;

		List<Pessoa> people = q.from(p).where(p.name.like("%")).list(p);

		assertThat(people, hasSize(10));
	}
}
