package com.simplilearn.la.dao;

import java.util.List;
import com.simplilearn.la.entity.Class;
import com.simplilearn.la.entity.ClassSubjectId;
import com.simplilearn.la.entity.ClassSubjectTeacher;
import com.simplilearn.la.entity.Subject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.la.entity.Teacher;
import com.simplilearn.la.exception.LAException;
import com.simplilearn.la.util.HibernateUtil;

public class TeacherDaoImpl implements Dao<Teacher>, TeacherDao {

	@Override
	public void save(Teacher teacher) throws LAException {
		if (teacher == null) throw new LAException("Error while saving teacher details. Please contact administrator !");

		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new LAException(e.getMessage());
        } 
		
	}

	@Override
	public List<Teacher> getAll() {
		List<Teacher> teachers = null;
		
		try (Session session= HibernateUtil.getSessionFactory().openSession();) {

//			teachers = session.createQuery("select t from Teacher t left join ClassSubjectTeacher cst on t.id = cst.teacher.id", Teacher.class).getResultList();
			teachers = session.createQuery("from Teacher ", Teacher.class).getResultList();

		} 
		return teachers;
	}

	

	@Override
	public Teacher getById(Long id) throws LAException {
		if (id == null) throw new LAException("Error while getting teacher details. Please contact administrator !");

		Teacher teacher = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
		
			 teacher = session.get(Teacher.class, id);

			
		} 
		return teacher;
	}

	@Override
	public void update(Teacher teacher) throws LAException {
		if (teacher == null) throw new LAException("Error while updating teacher details. Please contact administrator !");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.update(teacher);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new LAException(e.getMessage());        
		} 
		
	}

	@Override
	public void delete(Long id) throws LAException {
		if (id == null) throw new LAException("Error while deleting teacher details. Please contact administrator !");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			
			Teacher teacher = getById(id);
			if (teacher != null) {
				session.delete(teacher);
				transaction.commit();
			}
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
		} 

	}

	
	@Override
	public void assignTeacherToClass(Class cls, Teacher teacher, Subject subject) throws LAException {

		if (cls == null || teacher == null || subject == null) throw new LAException("Teacher cannot be assigned to the class. Invalid Details !!!");
		
		ClassSubjectId cstId =  new ClassSubjectId(cls, subject);
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			
			ClassSubjectTeacher cst = session.get(ClassSubjectTeacher.class, cstId);
			// no record in database so insert a new record
			if (cst == null){
				cst = new ClassSubjectTeacher(cstId, teacher);
				session.save(cst);
			} else {
				session.update(cst);
			}
	
			
			transaction.commit();
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
		} 

	}
	
	

}
