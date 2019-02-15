package com.qa.classroom.classroomapi.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.classroom.classroomapi.persistence.domain.SentIntake;
import com.qa.classroom.classroomapi.persistence.repository.MongoIntakeRepo;

@Component
public class IntakeReceiver {
	
	@Autowired
	private MongoIntakeRepo repo;
	
	@JmsListener(destination = "IntakeQueue", containerFactory = "myFactory")
	public void receiveMessage(SentIntake sentIntake) {
		repo.save(sentIntake);
	}

}
