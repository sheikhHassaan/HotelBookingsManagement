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
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    @SerializedName("hotel_id")
    private String hotelId;

    @Column(name = "hotel_name")
    @SerializedName("hotel_name")
    private String hotelName;

    @Column(name = "address")
    @SerializedName("address")
    private String address;

    @Column(name = "city")
    @SerializedName("city")
    private String city;

    @Column(name = "state")
    @SerializedName("state")
    private String state;

    @Column(name = "country")
    @SerializedName("country")
    private String country;

    @Column(name = "postal_code")
    @SerializedName("postal_code")
    private String postalCode;

    @Column(name = "phone_number")
    @SerializedName("phone_number")
    private String phoneNumber;

    @Column(name = "email")
    @SerializedName("email")
    private String email;

}