package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Booking;
import com.project.hotelBookingsManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingsServiceImpl {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBooking(String bookingId){
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        return optionalBooking.orElse(null);
    }

    public void addBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public void insertUpdateBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public void deleteBooking(String bookingId){
        bookingRepository.deleteById(bookingId);
    }
}