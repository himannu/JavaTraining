package com.simplilearn.la.dao;

import com.simplilearn.la.entity.Class;
import com.simplilearn.la.entity.Subject;
import com.simplilearn.la.entity.Teacher;
import com.simplilearn.la.exception.LAException;

public interface TeacherDao {
	public void assignTeacherToClass(Class cls, Teacher teacher, Subject subject) throws LAException;
}
