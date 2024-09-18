package com.project.hotelBookingsManagement.repository;

import com.project.hotelBookingsManagement.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {



}