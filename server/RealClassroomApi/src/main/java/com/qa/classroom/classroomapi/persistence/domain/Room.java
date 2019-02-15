package com.qa.classroom.classroomapi.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long classroomId;
	public String name;
	public int capacity;
	public int intakeId;
	public Boolean occupied; 
	
	public Room() {
	}
	
	public Room(String name, int capacity, int intakeId, Boolean occupied) {
		this.name = name;
		this.capacity = capacity;
		this.intakeId = intakeId;
		this.occupied = occupied;
	}

	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getIntakeId() {
		return intakeId;
	}

	public void setIntakeId(int intakeId) {
		this.intakeId = intakeId;
	}

	public Boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

}
