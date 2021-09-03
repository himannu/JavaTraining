package com.simplilearn.la.dao;

import java.util.List;

import com.simplilearn.la.exception.LAException;

public interface Dao<T> {
	
	List<T> getAll();
	T getById(Long id) throws LAException;
	void save(T t) throws LAException;
	void update(T t) throws LAException;
	void delete(Long id) throws LAException;

}
