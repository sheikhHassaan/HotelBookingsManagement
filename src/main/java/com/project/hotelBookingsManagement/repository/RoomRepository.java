package com.project.hotelBookingsManagement.repository;

import com.project.hotelBookingsManagement.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {



}