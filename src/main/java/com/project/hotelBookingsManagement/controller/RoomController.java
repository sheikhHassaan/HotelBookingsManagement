package com.project.hotelBookingsManagement.controller;

import com.project.hotelBookingsManagement.domain.Room;
import com.project.hotelBookingsManagement.service.RoomsServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel_bookings_management/room")
public class RoomController {

    RoomsServiceImpl roomService;

    @GetMapping("/list")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/get/{room_id}")
    public Room getRoom(@PathVariable("room_id") String roomId) {
        return roomService.getRoomById(roomId);
    }

    @PostMapping("/add")
    public void addRoom(@Validated @RequestBody Room room) {
        roomService.addRoom(room);
    }

    @PutMapping("/update/{room_id}")
    public void updateRoom(@PathVariable("room_id") String roomId, @RequestBody Room room) {
        if (roomId != null) {
            room.setRoomId(roomId);
        }
        roomService.updateRoom(room);
    }

    @DeleteMapping("/remove/{room_id}")
    public void removeRoom(@PathVariable("room_id") String roomId) {
        roomService.deleteRoom(roomId);
    }
}