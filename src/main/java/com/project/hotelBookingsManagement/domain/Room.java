package com.project.hotelBookingsManagement.domain;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    @SerializedName("room_id")
    private String roomId;

    @Column(name = "hotel_id")
    @SerializedName("hotel_id")
    private String hotelId;

    @Column(name = "room_number")
    @SerializedName("room_number")
    private String roomNumber;

    @Column(name = "room_type")
    @SerializedName("room_type")
    private String roomType;

    @Column(name = "price_per_night")
    @SerializedName("price_per_night")
    private Double pricePerNight;

    @Column(name = "availability_status")
    @SerializedName("availability_status")
    private Boolean availabilityStatus;

}