package com.qa.classroom.classroomapi.util.exceptions;

public class IntakeNotFoundException extends RuntimeException {
	
	public IntakeNotFoundException(String exception) {
		super("Id supplied does not exist. Id: " + exception);
	}

}
