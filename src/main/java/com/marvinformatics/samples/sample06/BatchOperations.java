package com.marvinformatics.samples.sample06;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.marvinformatics.samples.entity.QPerson;
import com.marvinformatics.samples.tests.TestsSetup;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAUpdateClause;

public class BatchOperations extends TestsSetup
{

  @Test
  public void delete()
  {
    QPerson p = QPerson.person;

    long result = new JPADeleteClause(em, p)
        .where(
            p.name.eq("p6"))
        .execute();

    assertThat(result, equalTo(1L));
  }

  @Test
  public void update()
  {
    QPerson p = QPerson.person;

    long result = new JPAUpdateClause(em, p)
        .where(
            p.name.eq("p5"))
        .set(p.name, "p55")
        .execute();

    assertThat(result, equalTo(1L));
  }
}
