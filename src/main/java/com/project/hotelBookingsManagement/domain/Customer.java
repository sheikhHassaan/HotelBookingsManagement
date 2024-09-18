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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false, updatable = false)
    @SerializedName("customer_id")
    private String customerId;

    @Column(name = "first_name")
    @SerializedName("first_name")
    private String firstName;

    @Column(name = "last_name")
    @SerializedName("last_name")
    private String lastName;

    @Column(name = "email")
    @SerializedName("email")
    private String email;

    @Column(name = "phone_number")
    @SerializedName("phone_number")
    private String phoneNumber;

}