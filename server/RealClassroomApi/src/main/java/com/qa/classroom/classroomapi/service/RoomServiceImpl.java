package com.qa.classroom.classroomapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.classroom.classroomapi.persistence.domain.Room;
import com.qa.classroom.classroomapi.persistence.repository.RoomRepository;
import com.qa.classroom.classroomapi.util.exceptions.RoomNotFoundException;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository repo;
	
	@Override
	public List<Room> getRooms() {
		return repo.findAll();
	}

	@Override
	public Room getRoom(Long id) {
		Optional<Room> room = repo.findById(id);
		return room.orElseThrow(() -> new RoomNotFoundException(id.toString()));
	}

}
