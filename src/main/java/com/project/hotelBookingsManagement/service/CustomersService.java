package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Customer;
import com.project.hotelBookingsManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String customerId) {
        Optional<Customer> optionalCustomer =  customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer insertUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}