package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Payment;
import com.project.hotelBookingsManagement.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl {

    @Autowired
    PaymentRepository PaymentRepository;

    public List<Payment> getAllPayments() {
        return PaymentRepository.findAll();
    }

    public Payment getPaymentById(String paymentId) {
        Optional<Payment> optionalPayment = PaymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    public void addPayment(Payment payment) {
        PaymentRepository.save(payment);
    }

    public void insertUpdatePayment(Payment payment) {
        PaymentRepository.save(payment);
    }

    public void deletePayment(String paymentId) {
        PaymentRepository.deleteById(paymentId);
    }

}