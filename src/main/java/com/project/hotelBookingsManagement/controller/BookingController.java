package com.project.hotelBookingsManagement.controller;

import com.project.hotelBookingsManagement.domain.Booking;
import com.project.hotelBookingsManagement.service.BookingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel_bookings_management/booking")
public class BookingController {

    @Autowired
    BookingsServiceImpl bookingService;

    @GetMapping("/list")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/get/{booking_id}")
    public Booking getBooking(@PathVariable("booking_id") String booking_id) {
        return bookingService.getBooking(booking_id);
    }

    @PostMapping("/add")
    public void addBooking(@Validated @RequestBody Booking booking) {
        bookingService.addBooking(booking);
    }

    @PutMapping("/update/{booking_id}")
    public void updateBooking(@PathVariable("booking_id") String bookingId, @RequestBody Booking booking) {
        if (bookingId != null) {
            booking.setBookingId(bookingId);
        }
        bookingService.updateBooking(booking);
    }

    @DeleteMapping("/remove/{booking_id}")
    public void removeBooking(@PathVariable("booking_id") String bookingId) {
        bookingService.deleteBooking(bookingId);
    }

}