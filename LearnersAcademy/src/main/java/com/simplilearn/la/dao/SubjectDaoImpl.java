package com.simplilearn.la.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.la.entity.Subject;
import com.simplilearn.la.exception.LAException;
import com.simplilearn.la.util.HibernateUtil;

public class SubjectDaoImpl implements Dao<Subject> {

	@Override
	public void save(Subject subject) throws LAException {
		if (subject == null) throw new LAException("Error while saving subject details. Please contact administrator !");
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
			
		} catch (Exception e) {
			
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
		
	}

	@Override
	public List<Subject> getAll() {
		List<Subject> subjects = null;
		
		try (Session session= HibernateUtil.getSessionFactory().openSession();) {
		
			subjects = session.createQuery("from Subject", Subject.class).getResultList();
			
		} 
		return subjects;
	}

	@Override
	public Subject getById(Long id) throws LAException {
		if (id == null) throw new LAException("Error while retrieving subject details. Please contact administrator !");

		Subject subject = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
		
			 subject = session.get(Subject.class, id);

			
		} 

		return subject;
	}

	@Override
	public void update(Subject subj) throws LAException {
		if (subj == null) throw new LAException("Error while updating subject details. Please contact administrator !");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.update(subj);
			transaction.commit();
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
		
	}

	@Override
	public void delete(Long id) throws LAException{
		if (id == null) throw new LAException("Error while deleting subject details. Please contact administrator !");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			
			Subject subj = getById(id);
			if (subj != null) {
				session.delete(subj);
				transaction.commit();
			}
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
	}
	
	

}
