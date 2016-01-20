package com.marvinformatics.samples.sample01;

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

import com.marvinformatics.samples.entity.Person;
import com.marvinformatics.samples.entity.Person_;
import com.marvinformatics.samples.entity.QPerson;
import com.marvinformatics.samples.tests.TestsSetup;
import com.querydsl.jpa.impl.JPAQuery;

public class Clash extends TestsSetup
{

  @Test
  public void jpaHql()
  {
    Query q = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name");
    q.setParameter("name", "%");
    @SuppressWarnings("unchecked")
    List<Person> people = q.getResultList();

    assertThat(people, hasSize(10));
  }

  @Test
  public void jpaCriteria()
  {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
    Root<Person> from = criteriaQuery.from(Person.class);
    Predicate predicate2 = criteriaBuilder.like(from.<String> get("name"), "%");
    criteriaQuery.where(criteriaBuilder.and(predicate2));

    CriteriaQuery<Person> select = criteriaQuery.select(from);
    TypedQuery<Person> typedQuery = em.createQuery(select);
    List<Person> people = typedQuery.getResultList();

    assertThat(people, hasSize(10));
  }

  @Test
  public void jpaCriteriaCodeGen()
  {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
    Root<Person> from = criteriaQuery.from(Person.class);
    Predicate predicate2 = criteriaBuilder.like(from.get(Person_.name), "%");
    criteriaQuery.where(criteriaBuilder.and(predicate2));

    CriteriaQuery<Person> select = criteriaQuery.select(from);
    TypedQuery<Person> typedQuery = em.createQuery(select);
    List<Person> people = typedQuery.getResultList();

    assertThat(people, hasSize(10));
  }

  @Test
  public void querydsl()
  {
    JPAQuery<Person> q = new JPAQuery<Person>(em);

    QPerson p = QPerson.person;

    List<Person> people = q
        .select(p)
        .from(p)
        .where(
            p.name.toLowerCase().like("p%"))
        .fetch();

    assertThat(people, hasSize(10));
  }
}
