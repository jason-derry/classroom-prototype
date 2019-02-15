package com.qa.classroom.classroomapi.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Intake {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long intakeId;
	public int size;
	public int classroomId;
	
	public Intake() {
	}
	
	public Intake(

}