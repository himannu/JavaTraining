package com.simplilearn.la.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private Class studentClass;
	
	public Student() {
	}
	
	public Student(Long id, String name, Address address, String emailId, String phoneNumber, Class studentClass) {
		super(id, name, address, emailId, phoneNumber);
		this.studentClass = studentClass;
	}


	public Class getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Class studentClass) {
		this.studentClass = studentClass;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
		result = prime * result + ((getEmailId() == null) ? 0 : getEmailId().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
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
		Student other = (Student) obj;
		if (getAddress() == null) {
			if (other.getAddress() != null)
				return false;
		} else if (!getAddress().equals(other.getAddress()))
			return false;
		if (getEmailId() == null) {
			if (other.getEmailId() != null)
				return false;
		} else if (!getEmailId().equals(other.getEmailId()))
			return false;
		if (getId() == null) {
			if (other.getId()!= null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getName()== null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getPhoneNumber() == null) {
			if (other.getPhoneNumber() != null)
				return false;
		} else if (!getPhoneNumber().equals(other.getPhoneNumber()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + getId()+ ", studentClass=" + studentClass + ", getName()=" + getName() + ", getAddress()="
				+ getAddress() + ", getEmailId()=" + getEmailId() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	
	
}
