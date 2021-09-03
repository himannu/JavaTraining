package com.simplilearn.la.dao;

import java.util.List;

import com.simplilearn.la.entity.Student;
import com.simplilearn.la.exception.LAException;

public interface StudentDao {
	
	void save(Student student) throws LAException ;
	List<Student> getAll(Long id) throws LAException;
	Student getById(Long id) throws LAException;
	void update(Student student) throws LAException;
	void delete(Long id) throws LAException;

}
