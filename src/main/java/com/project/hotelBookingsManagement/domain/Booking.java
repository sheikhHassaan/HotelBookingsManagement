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

import java.util.Date;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    @Id @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", updatable = false, nullable = false)
    @JsonProperty("booking_id")
    private String bookingId;

    @Column(name = "customer_id", nullable = false)
    @JsonProperty("customer_id")
    private String customerId;

    @Column(name = "room_id", nullable = false)
    @JsonProperty("room_id")
    private String roomId;

    @Column(name = "check_in_date")
    @JsonProperty("check_in_date")
    private Date checkInDate;

    @Column(name = "check_out_date")
    @JsonProperty("check_out_date")
    private Date checkOutDate;

    @Column(name = "booking_status")
    @JsonProperty("booking_status")
    private String bookingStatus;

    @Column(name = "total_amount")
    @JsonProperty("total_amount")
    private Double totalAmount;

}