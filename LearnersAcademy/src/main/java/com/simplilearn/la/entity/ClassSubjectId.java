package com.simplilearn.la.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ClassSubjectId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="class_id")
	private Class classFor;

	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;

	public ClassSubjectId() {
		
	}
	
	public ClassSubjectId(Class classes, Subject subject) {
		super();
		this.classFor = classes;
		this.subject = subject;
	}

	public Class getClassFor() {
		return classFor;
	}

	public void setClassFor(Class classes) {
		this.classFor = classes;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classFor == null) ? 0 : classFor.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		ClassSubjectId other = (ClassSubjectId) obj;
		if (classFor == null) {
			if (other.classFor != null)
				return false;
		} else if (!classFor.equals(other.classFor))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassSubjectId [class=" + classFor + ", subject=" + subject + "]";
	}
	
	
}
