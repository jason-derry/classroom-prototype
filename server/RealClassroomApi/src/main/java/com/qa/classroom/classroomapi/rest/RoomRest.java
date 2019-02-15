package com.qa.classroom.classroomapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.classroom.classroomapi.persistence.domain.Room;
import com.qa.classroom.classroomapi.service.RoomService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class RoomRest {
	
	@Autowired
	private RoomService service;
	
	@GetMapping("${path.getRooms}")
	public List<Room> getRooms() {
		return service.getRooms();
	}
	
	@GetMapping("${path.getRoomById}")
	public Room getRoom(@PathVariable Long id) {
		return service.getRoom(id);
	}
	
}
