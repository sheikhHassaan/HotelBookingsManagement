package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Room;
import com.project.hotelBookingsManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomsService {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(String roomId){
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        return optionalRoom.orElse(null);
    }

    public void addRoom(Room room){
        roomRepository.save(room);
    }

    public void insertUpdateRoom(Room room){
        roomRepository.save(room);
    }

    public void deleteRoom(String roomId){
        roomRepository.deleteById(roomId);
    }

}