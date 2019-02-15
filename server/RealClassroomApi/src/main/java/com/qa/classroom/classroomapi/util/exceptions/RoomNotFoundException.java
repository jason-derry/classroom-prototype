package com.qa.classroom.classroomapi.util.exceptions;

public class RoomNotFoundException extends RuntimeException {
	
	public RoomNotFoundException(String exception) {
		super("Id supplied does not exist. Id: " + exception);
	}

}