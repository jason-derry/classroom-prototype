package com.qa.classroom.classroomapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.classroom.classroomapi.persistence.domain.Intake;
import com.qa.classroom.classroomapi.persistence.domain.SentIntake;
import com.qa.classroom.classroomapi.service.IntakeService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class IntakeRest {
	
	@Autowired
	private IntakeService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("${path.getIntakes}")
	public List<Intake> getIntakes() {
		return service.getIntakes();
	}
	
	@GetMapping("${path.getIntakeById}")
	public Intake getIntake(@PathVariable Long id) {
		return service.getIntake(id);
	}
	
	@DeleteMapping("${path.deleteIntake}")
	public ResponseEntity<Object> deleteIntake(@PathVariable Long id) {
		return service.deleteIntake(id);
	}
	
	@PutMapping("${path.updateIntake}")
	public ResponseEntity<Object> updateIntake(@RequestBody Intake intake, @PathVariable Long id) {
		return service.updateIntake(intake, id);
	}
	
	@PostMapping("${path.createIntake}")
	public Intake createIntake(@RequestBody Intake intake) {
		sendToQueue(intake);
		return service.addIntake(intake);
	}
	
	private void sendToQueue(Intake intake) {
		SentIntake intakeToStore = new SentIntake(intake);
		jmsTemplate.convertAndSend("IntakeQueue", intakeToStore);
	}
}
