package com.contaazul.samples.samplecereja;
import static com.contaazul.dsl.DateDsl.date;
import static com.contaazul.dsl.DateDsl.months;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.contaazul.samples.entity.Banco;
import com.contaazul.samples.entity.Empresa;
import com.contaazul.samples.entity.NaturezaFinanceira;
import com.contaazul.samples.entity.QStatement;
import com.contaazul.samples.entity.Statement;
import com.contaazul.samples.factory.JPQLMockeryQuery;
import com.contaazul.samples.factory.JPQLQueryFactory;
import com.google.common.collect.Lists;
import com.mysema.query.types.EntityPath;

public class StatementServiceTest {

	private static final Date FUTURE = date().lastDayOfMonth().clearTime().toDate();

	private static final Date PAST = date().firstDayOfMonth().clearTime().toDate();

	@Mock
	private JPQLQueryFactory factory;

	private static final Empresa empresa;
	static {
		empresa = new Empresa();
		empresa.setId(99L);
	}

	private static final Statement statement1;
	static {
		statement1 = new Statement();
		statement1.setId(1L);
		statement1.setEmpresa(empresa);
		statement1.setExpirationDate(PAST);
		statement1.setBank(new Banco(1L));
		statement1.setCategory(new NaturezaFinanceira(10L));
		statement1.setDescription("Conta 01 empresa 99");
	}

	private static final Statement statement2;
	static {
		statement2 = new Statement();
		statement2.setId(2L);
		statement2.setEmpresa(empresa);
		statement2.setExpirationDate(FUTURE);
		statement2.setBank(new Banco(5L));
		statement2.setCategory(new NaturezaFinanceira(11L));
		statement2.setDescription("Conta 02 empresa 99");
	}

	private static final Statement statement3;
	static {
		statement3 = new Statement();
		statement3.setId(3L);
		statement3.setEmpresa(new Empresa(35L));
		statement3.setExpirationDate(PAST);
		statement3.setBank(new Banco(1L));
		statement3.setCategory(new NaturezaFinanceira(12L));
		statement3.setDescription("Conta 01 empresa 35");
	}

	private static final Statement statement4;
	static {
		statement4 = new Statement();
		statement4.setId(4L);
		statement4.setEmpresa(empresa);
		statement4.setExpirationDate(PAST);
		statement4.setBank(new Banco(6L));
		statement4.setCategory(new NaturezaFinanceira(11L));
		statement4.setDescription("Conta 03 empresa 99");
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		JPQLMockeryQuery q = new JPQLMockeryQuery();
		when(factory.from(Matchers.any(EntityPath.class))).thenReturn(q);

		List<Statement> statements = Lists.newArrayList();
		statements.add(statement1);
		statements.add(statement2);
		statements.add(statement3);
		statements.add(statement4);
		Collections.shuffle(statements);
		q.bind(QStatement.statement, statements);
	}

	@Test
	public void isIntanciable() {
		new StatementService();
	}

	@Test
	public void noFilter() {
		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(new StatementFilter());
		assertThat(statements, hasSize(3));

		assertThat(statements.get(0).getId(), equalTo(1L));
		assertThat(statements.get(1).getId(), equalTo(4L));
		assertThat(statements.get(2).getId(), equalTo(2L));
	}

	@Test
	public void allIncludeFilter() {
		StatementFilter sf = new StatementFilter();
		sf.banks(new ArrayList<Long>()).categories(new ArrayList<Long>()).start(date().subtract(months(3)).toDate());
		sf.end(date().add(months(3)).toDate()).description("");

		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(sf);
		assertThat(statements, hasSize(3));

		assertThat(statements.get(0).getId(), equalTo(1L));
		assertThat(statements.get(1).getId(), equalTo(4L));
		assertThat(statements.get(2).getId(), equalTo(2L));
	}

	@Test
	public void filteringBank() {
		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(new StatementFilter().banks(newArrayList(5L)));
		assertThat(statements, hasSize(1));

		assertThat(statements.get(0).getId(), equalTo(2L));
	}

	@Test
	public void filteringStartDate() {
		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(new StatementFilter().start(new Date()));
		assertThat(statements, hasSize(1));

		assertThat(statements.get(0).getId(), equalTo(2L));
	}

	@Test
	public void filteringEndDate() {
		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(new StatementFilter().end(new Date()));
		assertThat(statements, hasSize(2));

		assertThat(statements.get(0).getId(), equalTo(1L));
		assertThat(statements.get(1).getId(), equalTo(4L));
	}

	@Test
	public void filteringCategory() {
		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(new StatementFilter().categories(newArrayList(10L)));
		assertThat(statements, hasSize(1));

		assertThat(statements.get(0).getId(), equalTo(1L));
	}

	@Test
	public void filteringDescription() {
		StatementService ss = new StatementService(factory);
		List<Statement> statements = ss.list(new StatementFilter().description("cOnTa 03"));
		assertThat(statements, hasSize(1));

		assertThat(statements.get(0).getId(), equalTo(4L));
	}

}
