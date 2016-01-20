package com.marvinformatics.samples.tests;

import static com.google.common.collect.Lists.newArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.marvinformatics.samples.entity.Person;

public abstract class TestsSetup
{

  protected static EntityManager em;
  private static EntityTransaction transaction;

  @BeforeClass
  public static void beforeAll()
  {
    em = Persistence.createEntityManagerFactory("h2").createEntityManager();

    EntityTransaction t = em.getTransaction();
    t.begin();
    Person p1 = new Person("p1");
    em.persist(p1);
    em.persist(new Person("p2"));
    em.persist(new Person("p3"));
    em.persist(new Person("p4"));
    em.persist(new Person("p5"));
    em.persist(new Person("p6"));
    em.persist(new Person("p7"));
    em.persist(new Person("p8"));
    em.persist(new Person("p9"));
    Person p10 = new Person("p10");
    em.persist(p10);
    p1.setChildren(newArrayList(p10));
    em.merge(p1);
    t.commit();

    transaction = em.getTransaction();
    transaction.begin();
  }

  @AfterClass
  public static void afterAll()
  {
    transaction.commit();
    em.close();
  }

}
