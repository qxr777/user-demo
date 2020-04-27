package edu.whut.web.dao;

import java.util.List;

public interface BaseDao<T> {
	T insert(T object);

	T update(T object);

	T delete(T object);

	T findById(long id);
	
	T merge(T object);

	List<T> findAllOnes();
}