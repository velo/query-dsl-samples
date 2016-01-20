package com.marvinformatics.samples.sample03;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.marvinformatics.samples.entity.Person;
import com.marvinformatics.samples.entity.QPerson;
import com.marvinformatics.samples.tests.TestsSetup;
import com.querydsl.jpa.impl.JPAQuery;

public class OrderBy extends TestsSetup
{

  @Test
  public void jpaHql()
  {
    Query q = em.createQuery("SELECT p FROM Person p ORDER BY p.name ASC, p.id DESC" /*
                                                                                      * like
                                                                                      * p
                                                                                      * .
                                                                                      * name
                                                                                      */);
    @SuppressWarnings("unchecked")
    List<Person> people = q.getResultList();

    assertThat(people, hasSize(10));
  }

  @Test
  public void querydsl()
  {
    JPAQuery<Person> q = new JPAQuery<>(em);
    QPerson p = QPerson.person;

    List<Person> people = q.select(p).from(p).orderBy(p.name.asc(), p.id.desc()).fetch();

    assertThat(people, hasSize(10));
  }
}
