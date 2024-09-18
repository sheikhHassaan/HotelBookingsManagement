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
@Table(name = "payments")
public class Payment {

    @Id @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    @JsonProperty("payment_id")
    private String paymentId;

    @Column(name = "booking_id")
    @JsonProperty("booking_id")
    private String bookingId;

    @Column(name = "payment_date")
    @JsonProperty("payment_date")
    private Date paymentDate;

    @Column(name = "payment_amount")
    @JsonProperty("payment_amount")
    private Double paymentAmount;

    @Column(name = "payment_method")
    @JsonProperty("payment_method")
    private String paymentMethod;

}