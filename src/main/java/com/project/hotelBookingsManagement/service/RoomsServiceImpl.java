package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Room;
import com.project.hotelBookingsManagement.repository.RoomRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomsServiceImpl {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String roomId) {
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        return optionalRoom.orElse(null);
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public void updateRoom(Room room) {
        Room configRoom = roomRepository.findById(room.getRoomId()).orElse(null);
        if (configRoom != null) {
            room = mergeRoom(configRoom, room);
        }
        roomRepository.save(room);
    }

    public void deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
    }

    public Room mergeRoom(Room configRoom, Room newRoom) {
        if (StringUtils.isNotEmpty(newRoom.getHotelId())) {
            configRoom.setHotelId(newRoom.getHotelId());
        }
        if (StringUtils.isNotEmpty(newRoom.getRoomNumber())) {
            configRoom.setRoomId(newRoom.getRoomNumber());
        }
        if (StringUtils.isNotEmpty(newRoom.getRoomType())) {
            configRoom.setRoomType(newRoom.getRoomType());
        }
        if (newRoom.getPricePerNight() != null) {
            configRoom.setPricePerNight(newRoom.getPricePerNight());
        }
        if (newRoom.getAvailabilityStatus() != null) {
            configRoom.setAvailabilityStatus(newRoom.getAvailabilityStatus());
        }
        return configRoom;
    }

}