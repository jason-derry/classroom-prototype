package com.qa.classroom.classroomapi.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Intake {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long intakeId;
	private int size;
	private int classroomId;
	
	public Intake() {
	}
	
	public Intake(int size, int classroomId) {
		this.size = size;
		this.classroomId = classroomId;
	}

	public long getIntakeId() {
		return intakeId;
	}

	public void setIntakeId(long intakeId) {
		this.intakeId = intakeId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}
	
}