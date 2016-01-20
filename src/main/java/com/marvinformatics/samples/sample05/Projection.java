package com.marvinformatics.samples.sample05;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.marvinformatics.samples.entity.Person;
import com.marvinformatics.samples.entity.PersonInfo;
import com.marvinformatics.samples.entity.QPerson;
import com.marvinformatics.samples.entity.QPersonInfo;
import com.marvinformatics.samples.tests.TestsSetup;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;

public class Projection extends TestsSetup
{

  @Test
  public void jpaHql()
  {
    Query q = em.createQuery("SELECT new Person(p.name) FROM Person p");
    // esqueci de apagar q.setParameter("name", "%");
    @SuppressWarnings("unchecked")
    List<Person> people = q.getResultList();

    assertThat(people, hasSize(10));
    for (Person pessoa : people)
    {
      assertThat(pessoa.getId(), nullValue());
    }
  }

  @Test
  public void querydsl()
  {
    JPAQuery<PersonInfo> q = new JPAQuery<>(em);
    QPerson p = QPerson.person;

    List<PersonInfo> people = q
        .select(new QPersonInfo(p.name, p.children.size()))
        .from(p)
        .fetch();

    for (PersonInfo person : people)
    {
      System.out.println(person.getName() + person.getChildCount());
    }

  }

  @Test
  public void querydslTuple()
  {
    JPAQuery<Tuple> q = new JPAQuery<>(em);
    QPerson p = QPerson.person;

    List<Tuple> people = q
        .select(p.name, p.children.size())
        .from(p)
        .fetch();

    for (Tuple tuple : people)
    {
      System.out.println(tuple.get(p.name) + tuple.get(p.children.size()));
    }

  }
}
