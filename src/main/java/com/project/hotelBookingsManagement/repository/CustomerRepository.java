package com.project.hotelBookingsManagement.repository;

import com.project.hotelBookingsManagement.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {



}