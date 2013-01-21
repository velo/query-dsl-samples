package com.contaazul.samples.samplecereja;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.contaazul.samples.entity.QStatement;
import com.contaazul.samples.entity.Statement;
import com.contaazul.samples.factory.JPQLQueryFactory;
import com.mysema.query.jpa.JPQLQuery;


@NoArgsConstructor
@AllArgsConstructor
public class StatementService {

	private JPQLQueryFactory factory;

	public List<Statement> list(StatementFilter filter) {
		checkNotNull(filter);

		QStatement s = QStatement.statement;
		JPQLQuery q = factory.from(s);

		q.where(//
		s.empresa.id.eq(99L)//
		);
		if (filter.start() != null)
			q.where(s.expirationDate.goe(filter.start()));

		if (filter.end() != null)
			q.where(s.expirationDate.before(filter.end()));

		if (filter.banks() != null && !filter.banks().isEmpty())
			q.where(s.bank.id.in(filter.banks()));

		if (filter.categories() != null && !filter.categories().isEmpty())
			q.where(s.category.id.in(filter.categories()));

		if (filter.description() != null && !filter.description().isEmpty())
			q.where(s.description.toLowerCase().like("%" + filter.description().toLowerCase() + "%"));

		q.limit(filter.pageSize());
		q.offset(filter.page() * filter.pageSize());

		q.orderBy(s.expirationDate.asc(), s.id.asc());

		return q.list(//
		QStatement.create(s.id, s.expirationDate, s.categoryName, s.description, s.value)//
		);
	}

}
