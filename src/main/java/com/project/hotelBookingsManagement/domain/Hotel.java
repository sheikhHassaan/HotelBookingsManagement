package com.project.hotelBookingsManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@Table(name = "hotels")
public class Hotel {

    @Id @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    @JsonProperty("hotel_id")
    private String hotelId;

    @Column(name = "hotel_name")
    @JsonProperty("hotel_name")
    private String hotelName;

    @Column(name = "address")
    @JsonProperty("address")
    private String address;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "state")
    @JsonProperty("state")
    private String state;

    @Column(name = "country")
    @JsonProperty("country")
    private String country;

    @Column(name = "postal_code")
    @JsonProperty("postal_code")
    private String postalCode;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

}