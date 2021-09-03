package com.simplilearn.la.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="teacher_id")
	private Long id;

	@OneToMany(mappedBy = "teacher")
	private Set<ClassSubjectTeacher> subjectTeacherForClass;

	public Teacher() {
		
	}

	public Teacher(Long id, String name, Address address, String emailId, String phoneNumber) {
		super(name, address, emailId, phoneNumber);
		this.id = id;
	}

	public Teacher(Long id, String name, Address address, String emailId, String phoneNumber, Set<ClassSubjectTeacher> subjectTeacherForClass) {
		super(name, address, emailId, phoneNumber);
		this.id = id;
		this.subjectTeacherForClass = subjectTeacherForClass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<ClassSubjectTeacher> getSubjectTeacherForClass() {
		return subjectTeacherForClass;
	}

	public void setSubjectTeacherForClass(Set<ClassSubjectTeacher> subjectTeacherForClass) {
		this.subjectTeacherForClass = subjectTeacherForClass;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherName=" + getName() + ", teacherEmail=" + getEmailId() + ", teacherPhone=" + getPhoneNumber() +"]";
	}
	
	
	
	
	
	
	
	


}
