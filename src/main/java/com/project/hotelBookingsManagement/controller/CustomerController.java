package com.project.hotelBookingsManagement.controller;

import com.project.hotelBookingsManagement.domain.Customer;
import com.project.hotelBookingsManagement.service.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel_bookings_management/customer")
public class CustomerController {

    @Autowired
    CustomersServiceImpl customerService;

    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/{customer_id}")
    public Customer getCustomer(@PathVariable("customer_id") String customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/add")
    public void addCustomer(@Validated @RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/update/{customer_id}")
    public void updateCustomer(@PathVariable("customer_id") String customerId, @RequestBody Customer customer) {
        if (customerId != null) {
            customer.setCustomerId(customerId);
        }
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/remove/{customer_id}")
    public void removeCustomer(@PathVariable("customer_id") String customerId) {
        customerService.deleteCustomer(customerId);
    }

}