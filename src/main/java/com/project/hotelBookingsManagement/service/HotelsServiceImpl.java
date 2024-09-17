package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Hotel;
import com.project.hotelBookingsManagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsServiceImpl {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(String hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        return optionalHotel.orElse(null);
    }

    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void insertUpdateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(String hotelId) {
        hotelRepository.deleteById(hotelId);
    }

}