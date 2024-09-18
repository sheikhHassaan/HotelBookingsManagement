package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Customer;
import com.project.hotelBookingsManagement.repository.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        Customer configCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        if (configCustomer != null) {
            customer = mergeCustomer(configCustomer, customer);
        }
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer mergeCustomer(Customer configCustomer, Customer newCustomer) {

        if (StringUtils.isNotEmpty(newCustomer.getFirstName())) {
            configCustomer.setFirstName(newCustomer.getFirstName());
        }
        if (StringUtils.isNotEmpty(newCustomer.getLastName())) {
            configCustomer.setLastName(newCustomer.getLastName());
        }
        if (StringUtils.isNotEmpty(newCustomer.getEmail())) {
            configCustomer.setEmail(newCustomer.getEmail());
        }
        if (StringUtils.isNotEmpty(newCustomer.getPhoneNumber())) {
            configCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
        }
        return configCustomer;
    }

}