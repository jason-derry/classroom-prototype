package com.qa.classroom.classroomapi.service;

import java.util.List;

import com.qa.classroom.classroomapi.persistence.domain.Room;

public interface RoomService {
	
	List<Room> getRooms();
	
	Room getRoom(Long id);

}
