package com.marvinformatics.samples.sample04;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.marvinformatics.samples.entity.Person;
import com.marvinformatics.samples.entity.QPerson;
import com.marvinformatics.samples.tests.TestsSetup;
import com.querydsl.jpa.impl.JPAQuery;

public class Joins extends TestsSetup
{

  @Test
  public void jpaHql()
  {
    Query q = em.createQuery("SELECT p FROM Person p inner join p.children as c " +
        "WHERE c.name LIKE :name");
    q.setParameter("name", "%");
    @SuppressWarnings("unchecked")
    List<Person> people = q.getResultList();

    assertThat(people, hasSize(1));
  }

  @Test
  public void querydsl()
  {
    JPAQuery<Person> q = new JPAQuery<>(em);
    QPerson p = QPerson.person;
    QPerson c = new QPerson("child");

    List<Person> people = q
        .select(p)
        .from(p)
        .join(p.children, c)
        .where(
            c.name.like("%"))
        .fetch();

    assertThat(people, hasSize(1));
  }
}
