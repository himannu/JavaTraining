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
@Table(name="subjects")
@NamedQuery(name="SUBJECTS_NOT_IN_CLASS", query="from Subject s where s.id not in (select cst.classSubjectId.subject.id from ClassSubjectTeacher cst "
		+ " where cst.classSubjectId.classFor.classId=:clsId)")
public class Subject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="subject_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String subjectType;
	
	@OneToMany(mappedBy = "classSubjectId.subject",  cascade = CascadeType.ALL)
	private Set<ClassSubjectTeacher> classSubjects = new HashSet<ClassSubjectTeacher>();
	
	public Subject() {
	}

	public Subject(String name, String subjectType) {
		super();
		this.name = name;
		this.subjectType = subjectType;
	}

	public Subject(Long id, String name, String subjectType) {
		super();
		this.id = id;
		this.name = name;
		this.subjectType = subjectType;
	}

	public Subject(Long id, String name, String subjectType, Set<ClassSubjectTeacher> classSubjects) {
		super();
		this.id = id;
		this.name = name;
		this.subjectType = subjectType;
		this.classSubjects = classSubjects;
	}
	
	public Long getId() {
		return id;
	}
	
	

	public Set<ClassSubjectTeacher> getClassSubjects() {
		return classSubjects;
	}

	public void setClassSubjects(Set<ClassSubjectTeacher> classSubjects) {
		this.classSubjects = classSubjects;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subjectType == null) ? 0 : subjectType.hashCode());
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
		Subject other = (Subject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subjectType == null) {
			if (other.subjectType != null)
				return false;
		} else if (!subjectType.equals(other.subjectType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", subjectType=" + subjectType + "]";
	}
	
	

}
