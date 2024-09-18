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
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    @SerializedName("payment_id")
    private String paymentId;

    @Column(name = "booking_id")
    @SerializedName("booking_id")
    private String bookingId;

    @Column(name = "payment_date")
    @SerializedName("payment_date")
    private Date paymentDate;

    @Column(name = "payment_amount")
    @SerializedName("payment_amount")
    private Double paymentAmount;

    @Column(name = "payment_method")
    @SerializedName("payment_method")
    private String paymentMethod;

}