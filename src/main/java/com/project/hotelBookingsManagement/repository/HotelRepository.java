package com.project.hotelBookingsManagement.repository;

import com.project.hotelBookingsManagement.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {



}