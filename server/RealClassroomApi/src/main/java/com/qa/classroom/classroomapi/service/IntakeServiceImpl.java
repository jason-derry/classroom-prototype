package com.qa.classroom.classroomapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.classroom.classroomapi.persistence.domain.Intake;
import com.qa.classroom.classroomapi.persistence.repository.IntakeRepository;
import com.qa.classroom.classroomapi.util.exceptions.IntakeNotFoundException;

@Service
public class IntakeServiceImpl implements IntakeService {
	
	@Autowired
	private IntakeRepository repo;

	@Override
	public List<Intake> getIntakes() {
		return repo.findAll();
	}

	@Override
	public Intake getIntake(Long id) {
		Optional<Intake> intake = repo.findById(id);
		return intake.orElseThrow(() -> new IntakeNotFoundException(id.toString()));
	}

	@Override
	public Intake addIntake(Intake intake) {
		return repo.save(intake);
	}

	@Override
	public ResponseEntity<Object> deleteIntake(Long id) {
		if(intakeExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Object> updateIntake(Intake intake, Long id) {
		if(intakeExists(id)) {
			intake.setIntakeId(id);
			repo.save(intake);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.ok().build();
	}
	
	private boolean intakeExists(Long id) {
		Optional<Intake> intakeOptional = repo.findById(id);
		return intakeOptional.isPresent();
	}

}
