package com.marvinformatics.samples.sample02;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.marvinformatics.samples.entity.Person;
import com.marvinformatics.samples.entity.QPerson;
import com.marvinformatics.samples.tests.TestsSetup;
import com.querydsl.jpa.impl.JPAQuery;

public class Conditional extends TestsSetup
{

  private int randomNumber;

  @Before
  public void setup()
  {
    randomNumber = 42;
  }

  @Test
  public void jpaHql()
  {
    String hql = "SELECT p FROM Person p";
    if (randomNumber > 10)
      hql += /* esqueci o espaco */" WHERE p.name LIKE :name";

    Query q = em.createQuery(hql);
    q.setParameter("name", "%");
    @SuppressWarnings("unchecked")
    List<Person> people = q.getResultList();

    assertThat(people, hasSize(10));
  }

  @Test
  public void querydsl()
  {
    JPAQuery<Person> q = new JPAQuery<>(em);
    QPerson p = QPerson.person;

    q
        .select(p)
        .from(p);

    if (randomNumber > 10)
      q.where(p.name.like("%"));

    List<Person> people = q.fetch();

    assertThat(people, hasSize(10));
  }
}
