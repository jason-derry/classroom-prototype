package com.qa.classroom.classroomapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.classroom.classroomapi.persistence.domain.Intake;

public interface IntakeService {
	
	List<Intake> getIntakes();
	
	Intake getIntake(Long id);
	
	Intake addIntake(Intake intake);
	
	ResponseEntity<Object> deleteIntake(Long id);
	
	ResponseEntity<Object> updateIntake(Intake intake, Long id);

}
