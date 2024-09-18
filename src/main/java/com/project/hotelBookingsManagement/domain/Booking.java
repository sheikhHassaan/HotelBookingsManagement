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

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", updatable = false, nullable = false)
    @SerializedName("booking_id")
    private String bookingId;

    @Column(name = "customer_id", nullable = false)
    @SerializedName("customer_id")
    private String customerId;

    @Column(name = "room_id", nullable = false)
    @SerializedName("room_id")
    private String roomId;

    @Column(name = "check_in_date")
    @SerializedName("check_in_date")
    private Date checkInDate;

    @Column(name = "check_out_date")
    @SerializedName("check_out_date")
    private Date checkOutDate;

    @Column(name = "booking_status")
    @SerializedName("booking_status")
    private String bookingStatus;

    @Column(name = "total_amount")
    @SerializedName("total_amount")
    private Double totalAmount;

}