package com.contaazul.samples.sample06;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.contaazul.samples.entity.QPessoa;
import com.contaazul.samples.tests.TestsSetup;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAUpdateClause;

public class BatchOperations extends TestsSetup {

	@Test
	public void delete() {
		QPessoa p = QPessoa.pessoa;
		long result = new JPADeleteClause(em, p).where(p.name.eq("p6")).execute();
		assertThat(result, equalTo(1L));
	}

	@Test
	public void update() {
		QPessoa p = QPessoa.pessoa;
		long result = new JPAUpdateClause(em, p).where(p.name.eq("p5")).set(p.name, "p55").execute();
		assertThat(result, equalTo(1L));
	}
}
