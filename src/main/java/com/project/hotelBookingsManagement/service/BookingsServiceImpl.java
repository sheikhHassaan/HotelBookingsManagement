package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Booking;
import com.project.hotelBookingsManagement.repository.BookingRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingsServiceImpl {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBooking(String bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        return optionalBooking.orElse(null);
    }

    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void updateBooking(Booking booking) {

        Booking configBooking = bookingRepository.findById(booking.getBookingId()).orElse(null);
        if (configBooking != null) {
            booking = mergeBooking(configBooking, booking);
        }
        bookingRepository.save(booking);
    }

    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Booking mergeBooking(Booking configBooking, Booking newBooking) {
        if (StringUtils.isNotEmpty(newBooking.getCustomerId())) {
            configBooking.setCustomerId(newBooking.getCustomerId());
        }
        if (StringUtils.isNotEmpty(newBooking.getRoomId())) {
            configBooking.setRoomId(newBooking.getRoomId());
        }
        if (StringUtils.isNotEmpty(newBooking.getBookingStatus())) {
            configBooking.setBookingStatus(newBooking.getBookingStatus());
        }
        if (newBooking.getCheckInDate() != null) {
            configBooking.setCheckInDate(newBooking.getCheckInDate());
        }
        if (newBooking.getCheckOutDate() != null) {
            configBooking.setCheckOutDate(newBooking.getCheckOutDate());
        }
        if (newBooking.getTotalAmount() != null) {
            configBooking.setTotalAmount(newBooking.getTotalAmount());
        }
        return configBooking;
    }
}