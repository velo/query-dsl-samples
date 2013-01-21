package com.contaazul.samples.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysema.commons.lang.CloseableIterator;
import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.JoinType;
import com.mysema.query.ResultTransformer;
import com.mysema.query.SearchResults;
import com.mysema.query.collections.ColQueryMixin;
import com.mysema.query.collections.DefaultQueryEngine;
import com.mysema.query.collections.QueryEngine;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.support.QueryBase;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Expression;
import com.mysema.query.types.MapExpression;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;

public class JPQLMockeryQuery extends QueryBase<JPQLMockeryQuery> implements JPQLQuery {

	private final Map<Expression<?>, Iterable<?>> iterables = new HashMap<Expression<?>, Iterable<?>>();

	private final QueryEngine queryEngine;

	public JPQLMockeryQuery() {
		this(new ColQueryMixin<JPQLMockeryQuery>(new DefaultQueryMetadata()), DefaultQueryEngine.DEFAULT);
		this.queryMixin.setSelf(this);
	}

	public JPQLMockeryQuery(ColQueryMixin<JPQLMockeryQuery> queryMixin, QueryEngine queryEngine) {
		super(queryMixin);
		this.queryEngine = queryEngine;
	}

	@Override
	public JPQLQuery from(EntityPath<?>... sources) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery innerJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery innerJoin(EntityPath<P> target, EntityPath<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery innerJoin(Path<? extends Collection<P>> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery innerJoin(Path<? extends Collection<P>> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery innerJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery innerJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery join(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery join(EntityPath<P> target, EntityPath<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery join(Path<? extends Collection<P>> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery join(Path<? extends Collection<P>> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery join(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery join(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery leftJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery leftJoin(EntityPath<P> target, EntityPath<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery leftJoin(Path<? extends Collection<P>> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery leftJoin(Path<? extends Collection<P>> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery leftJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery leftJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery rightJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery rightJoin(EntityPath<P> target, EntityPath<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery rightJoin(Path<? extends Collection<P>> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery rightJoin(Path<? extends Collection<P>> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery rightJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery rightJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery fullJoin(EntityPath<P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery fullJoin(EntityPath<P> target, EntityPath<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery fullJoin(Path<? extends Collection<P>> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery fullJoin(Path<? extends Collection<P>> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery fullJoin(MapExpression<?, P> target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <P> JPQLQuery fullJoin(MapExpression<?, P> target, Path<P> alias) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public JPQLQuery with(Predicate... condition) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countDistinct() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean notExists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CloseableIterator<Object[]> iterate(Expression<?> first, Expression<?> second, Expression<?>... rest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public CloseableIterator<Object[]> iterate(Expression<?>[] args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> CloseableIterator<RT> iterate(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public CloseableIterator<Object[]> iterateDistinct(Expression<?> first, Expression<?> second, Expression<?>... rest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public CloseableIterator<Object[]> iterateDistinct(Expression<?>[] args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> CloseableIterator<RT> iterateDistinct(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> List<RT> list(Expression<RT> projection) {
		try {
			projection = queryMixin.convert(projection);
			queryMixin.addToProjection(projection);
			return queryEngine.list(queryMixin.getMetadata(), iterables, projection);
		} finally {
			reset();
		}
	}

	private void reset() {
		queryMixin.getMetadata().reset();
	}

	@Override
	public List<Object[]> list(Expression<?> first, Expression<?> second, Expression<?>... rest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Object[]> list(Expression<?>[] args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Object[]> listDistinct(Expression<?> first, Expression<?> second, Expression<?>... rest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Object[]> listDistinct(Expression<?>[] args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> List<RT> listDistinct(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> SearchResults<RT> listResults(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> SearchResults<RT> listDistinctResults(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <K, V> Map<K, V> map(Expression<K> key, Expression<V> value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] singleResult(Expression<?> first, Expression<?> second, Expression<?>... rest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] singleResult(Expression<?>[] args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> RT singleResult(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T transform(ResultTransformer<T> transformer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] uniqueResult(Expression<?> first, Expression<?> second, Expression<?>... rest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] uniqueResult(Expression<?>[] args) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <RT> RT uniqueResult(Expression<RT> projection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public JPQLQuery fetch() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public JPQLQuery fetchAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public <A> JPQLMockeryQuery bind(Path<A> entity, Iterable<? extends A> col) {
		iterables.put(entity, col);
		queryMixin.getMetadata().addJoin(JoinType.DEFAULT, entity);
		return this;
	}

	@Override
	public JPQLMockeryQuery where(Predicate... o) {
		return super.where(o);
	}

}
