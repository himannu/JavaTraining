package com.simplilearn.la.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.la.entity.Student;
import com.simplilearn.la.exception.LAException;
import com.simplilearn.la.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void save(Student student) throws LAException {
		if (student == null) throw new LAException("Error while saving student details. Please contact administrator !");

		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			
		} catch (Exception e) {
            
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
        } 
		
	}

	@Override
	public List<Student> getAll(Long classId) throws LAException {
		if (classId == null) throw new LAException("Error while getting student details for a class. Please contact administrator !");

		List<Student> students = null;
		
		try (Session session= HibernateUtil.getSessionFactory().openSession();) {
		
			TypedQuery<Student> query = session.createQuery("Select s from Student s where s.studentClass.classId = :classId", Student.class);
			query.setParameter("classId", classId);
			students = query.getResultList();
			
		} 
		return students;
	}

	@Override
	public Student getById(Long id) throws LAException {
		if (id == null) throw new LAException("Error while getting student details. Please contact administrator !");

		Student student = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
		
			 student = session.get(Student.class, id);

			
		} 

		return student;
	}

	@Override
	public void update(Student student) throws LAException {
		if (student == null) throw new LAException("Error while updating student details. Please contact administrator !");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
		
	}

	@Override
	public void delete(Long id) throws LAException {
		if (id == null) throw new LAException("Error while deleting student details. Please contact administrator !");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			
			Student student = getById(id);
			if (student != null) {
				session.delete(student);
				transaction.commit();
			}
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
	}
	
	

}
