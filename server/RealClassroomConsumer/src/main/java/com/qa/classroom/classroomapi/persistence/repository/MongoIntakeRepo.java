package com.qa.classroom.classroomapi.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.classroom.classroomapi.persistence.domain.SentIntake;

@Repository
public interface MongoIntakeRepo extends MongoRepository<SentIntake, Long>{
}