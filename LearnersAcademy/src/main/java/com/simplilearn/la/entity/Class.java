package com.simplilearn.la.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classes")
//@NamedQuery(name="CLASS_WITH_SUBJECTS",query = "Select c from Class c left join Students s where c.classId = s.studentClass.classId and c.classId = :classId")
public class Class implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="class_id")
	private Long classId;

	@Column(name="name", nullable = false, unique = true)
	private String className;

	@Column(name="description")
	private String classDescription;
	
	@OneToMany(mappedBy = "studentClass", cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<Student>();

	@OneToMany(mappedBy = "classSubjectId.classFor",  cascade = CascadeType.ALL)
	private Set<ClassSubjectTeacher> subjectTeacher = new HashSet<ClassSubjectTeacher>();
	

	public Class() {
		
	}
	
	public Class(Long classId, String className, String classDescription) {
		super();
		this.classId = classId;
		this.className = className;
		this.classDescription = classDescription;
	}
	
	public Class(String className, String classDescription) {
		super();
		this.className = className;
		this.classDescription = classDescription;
	}
	
	public Class(Long classId, Set<ClassSubjectTeacher> subjectTeacher, String className, String classDescription,
			Set<Student> students) {
		super();
		this.classId = classId;
		this.subjectTeacher = subjectTeacher;
		this.className = className;
		this.classDescription = classDescription;
		this.students = students;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Set<ClassSubjectTeacher> getSubjectTeacher() {
		return subjectTeacher;
	}

	public void setSubjectTeacher(Set<ClassSubjectTeacher> subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}
	

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classDescription == null) ? 0 : classDescription.hashCode());
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class other = (Class) obj;
		if (classDescription == null) {
			if (other.classDescription != null)
				return false;
		} else if (!classDescription.equals(other.classDescription))
			return false;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Class [classId=" + classId + ", , className=" + className
				+ ", classDescription=" + " classDescription]";
	}
	
	
}
