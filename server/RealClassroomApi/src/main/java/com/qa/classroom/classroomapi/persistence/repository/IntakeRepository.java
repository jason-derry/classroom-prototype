package com.qa.classroom.classroomapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.classroom.classroomapi.persistence.domain.Intake;

@Repository
public interface IntakeRepository extends JpaRepository<Intake, Long> {
}
