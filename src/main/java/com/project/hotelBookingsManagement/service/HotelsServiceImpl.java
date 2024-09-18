package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Hotel;
import com.project.hotelBookingsManagement.repository.HotelRepository;
import io.micrometer.common.util.StringUtils;
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

    public void updateHotel(Hotel hotel) {
        Hotel configHotel = hotelRepository.findById(hotel.getHotelId()).orElse(null);
        if (configHotel != null) {
            hotel = mergeHotel(configHotel, hotel);
        }
        hotelRepository.save(hotel);
    }

    public void deleteHotel(String hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public Hotel mergeHotel(Hotel configHotel, Hotel newHotel) {
        if (StringUtils.isNotEmpty(newHotel.getHotelName())) {
            configHotel.setHotelName(newHotel.getHotelName());
        }
        if (StringUtils.isNotEmpty(newHotel.getAddress())) {
            configHotel.setAddress(newHotel.getAddress());
        }
        if (StringUtils.isNotEmpty(newHotel.getCity())) {
            configHotel.setCity(newHotel.getCity());
        }
        if (StringUtils.isNotEmpty(newHotel.getState())) {
            configHotel.setState(newHotel.getState());
        }
        if (StringUtils.isNotEmpty(newHotel.getCountry())) {
            configHotel.setCountry(newHotel.getCountry());
        }
        if (StringUtils.isNotEmpty(newHotel.getPostalCode())) {
            configHotel.setPostalCode(newHotel.getPostalCode());
        }
        if (StringUtils.isNotEmpty(newHotel.getPhoneNumber())) {
            configHotel.setPhoneNumber(newHotel.getPhoneNumber());
        }
        if (StringUtils.isNotEmpty(newHotel.getEmail())) {
            configHotel.setEmail(newHotel.getEmail());
        }
        return configHotel;
    }

}