package com.qa.classroom.classroomapi.persistence.domain;

public class SentIntake {
	
	private Long intakeId;
	private int size;
	private int classroomId;
	
	public SentIntake() {
	}
	
	public SentIntake(Long intakeId, int size, int classroomId) {
		this.intakeId = intakeId;
		this.size = size;
		this.classroomId = classroomId;
	}

	public Long getIntakeId() {
		return intakeId;
	}

	public void setIntakeId(Long intakeId) {
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
