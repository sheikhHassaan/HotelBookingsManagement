package com.project.hotelBookingsManagement.controller;

import com.project.hotelBookingsManagement.domain.Hotel;
import com.project.hotelBookingsManagement.service.HotelsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel_bookings_management/hotel")
public class HotelController {

    @Autowired
    HotelsServiceImpl hotelService;

    @GetMapping("/list")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/get/{hotel_id}")
    public Hotel getHotel(@PathVariable("hotel_id") String hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping("/add")
    public void addHotel(@Validated @RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }

    @PutMapping("/update/{hotel_id}")
    public void updateHotel(@PathVariable("hotel_id") String hotelId, @RequestBody Hotel hotel) {
        if (hotelId != null) {
            hotel.setHotelId(hotelId);
        }
        hotelService.updateHotel(hotel);
    }

    @DeleteMapping("/remove/{hotel_id}")
    public void removeHotel(@PathVariable("hotel_id") String hotelId) {
        hotelService.deleteHotel(hotelId);
    }
}