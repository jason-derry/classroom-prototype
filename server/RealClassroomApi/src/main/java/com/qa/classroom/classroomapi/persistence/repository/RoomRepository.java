package com.qa.classroom.classroomapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.classroom.classroomapi.persistence.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}