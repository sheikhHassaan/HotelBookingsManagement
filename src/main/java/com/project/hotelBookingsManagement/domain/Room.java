package com.project.hotelBookingsManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    @JsonProperty("room_id")
    private String roomId;

    @Column(name = "hotel_id")
    @JsonProperty("hotel_id")
    private String hotelId;

    @Column(name = "room_number")
    @JsonProperty("room_number")
    private String roomNumber;

    @Column(name = "room_type")
    @JsonProperty("room_type")
    private String roomType;

    @Column(name = "price_per_night")
    @JsonProperty("price_per_night")
    private Double pricePerNight;

    @Column(name = "availability_status")
    @JsonProperty("availability_status")
    private Boolean availabilityStatus;

}