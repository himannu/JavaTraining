package com.simplilearn.la.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="class_subject_teacher")
//@NamedQuery(name="SUBJECT_TEACHERS_FOR_CLASS", query="Select cst from ClassSubjectTeacher cst where cst.classSubjectId.classFor.classId = :classId")
/*
 * @AssociationOverrides({
    @AssociationOverride(name = "classSubjectId.class",
        joinColumns = @JoinColumn(name = "class_id")),
    @AssociationOverride(name = "classSubjectId.subject",
        joinColumns = @JoinColumn(name = "subject_id")) })
 * 
 */
public class ClassSubjectTeacher implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Embedded
	private ClassSubjectId classSubjectId;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	
	public ClassSubjectTeacher() {
	}

	public ClassSubjectTeacher(ClassSubjectId classSubjectId, Teacher teacher) {
		super();
		this.classSubjectId = classSubjectId;
		this.teacher = teacher;
	}

	public ClassSubjectId getClassSubjectId() {
		return classSubjectId;
	}

	public void setClassSubjectId(ClassSubjectId classSubjectId) {
		this.classSubjectId = classSubjectId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classSubjectId == null) ? 0 : classSubjectId.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		ClassSubjectTeacher other = (ClassSubjectTeacher) obj;
		if (classSubjectId == null) {
			if (other.classSubjectId != null)
				return false;
		} else if (!classSubjectId.equals(other.classSubjectId))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassSubjectTeacher [classId=" + classSubjectId.getClassFor().getClassName() + classSubjectId.getSubject().getName() + ", teacher=" + teacher + "]";
	}
	
	
	

}
