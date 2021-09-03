package com.simplilearn.la.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.la.entity.Class;
import com.simplilearn.la.entity.ClassSubjectId;
import com.simplilearn.la.entity.ClassSubjectTeacher;
import com.simplilearn.la.entity.Student;
import com.simplilearn.la.entity.Subject;
import com.simplilearn.la.exception.LAException;
import com.simplilearn.la.util.HibernateUtil;

public class ClassDaoImpl implements Dao<Class> {

	Dao<Subject> subjectDao = null;
	
	public ClassDaoImpl() {
		subjectDao = new SubjectDaoImpl();
	}
	
	@Override
	public void save(Class cls) throws LAException {
		if (cls == null) throw new LAException("Error while saving class details. Please contact administrator !");

		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.save(cls);
			transaction.commit();
			
		} catch (Exception e) {
            
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
        } 
		
	}

	@Override
	public List<Class> getAll() {
		List<Class> classes = null;
		
		try (Session session= HibernateUtil.getSessionFactory().openSession();) {
		
			classes = session.createQuery("from Class", Class.class).getResultList();
			
		} 
		return classes;
	}

	public List<Subject> listSubjectsNotInClass(Long classId) throws LAException {
		List<Subject> subjects = null;
		try (Session session= HibernateUtil.getSessionFactory().openSession();) {
			
			subjects = session.createNamedQuery("SUBJECTS_NOT_IN_CLASS", Subject.class).setParameter("clsId", classId).getResultList();
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
		
		return subjects;
	}

	public void addSubjects(List<String> subjectIds, Long classId) throws LAException {
		
		try (Session session= HibernateUtil.getSessionFactory().openSession();) {
		
			Class cls = getById(classId);
			
			session.beginTransaction();
			
			for (String subjectId: subjectIds) {
				Long id = Long.parseLong(subjectId);
				Subject subject = subjectDao.getById(id);
				ClassSubjectTeacher cst = new ClassSubjectTeacher(new ClassSubjectId(cls, subject), null);
				session.save(cst);
			}
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 		
	}

	@Override
	public Class getById(Long id) throws LAException {
		if (id == null) throw new LAException("Error while getting class details. Please contact administrator !");

		Class cls = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
		
			 cls = session.get(Class.class, id);

			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
		return cls;
	}

	@Override
	public void update(Class cls)  throws LAException {
		
		if (cls == null) throw new LAException("Error while updating class details. Please contact administrator !");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			session.update(cls);
			transaction.commit();
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
            
		} 
		
	}

	@Override
	public void delete(Long id) throws LAException {
		
		if (id == null) throw new LAException("Error while deleting class details. Please contact administrator !");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			transaction = session.beginTransaction();
			
			Class cls = getById(id);
			if (cls != null) {
				session.delete(cls);
				transaction.commit();
			}
			
		} catch (Exception e) {
            e.printStackTrace();
            throw new LAException(e.getMessage());
        } 

	}
	
	public Class getClassReport(Long classId) throws LAException {
		if (classId == null) throw new LAException("Error while deleting class details. Please contact administrator !");
		Class cls = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession();) {
			
			cls = session.get(Class.class, classId);
			if (cls == null) throw new LAException("Could not retrieve class details from database. Please contact administrator !");
			Set<Student> students = cls.getStudents();
			Set<ClassSubjectTeacher> subjectTeacher = cls.getSubjectTeacher();
			students.stream().forEach(System.out::println);
			subjectTeacher.forEach(System.out::println);
			
			//Class classWithSubjects = session.createNamedQuery("CLASS_WITH_SUBJECTS", Class.class).setParameter("classId", classId).getSingleResult();
			//List<ClassSubjectTeacher> teachers =session.createNamedQuery("SUBJECT_TEACHERS_FOR_CLASS", ClassSubjectTeacher.class).setParameter("classId", classId).getResultList();
		}
		return cls;

	}

}
