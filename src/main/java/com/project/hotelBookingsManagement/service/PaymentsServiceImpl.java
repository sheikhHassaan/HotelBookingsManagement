package com.project.hotelBookingsManagement.service;

import com.project.hotelBookingsManagement.domain.Payment;
import com.project.hotelBookingsManagement.repository.PaymentRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(String paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void updatePayment(Payment payment) {
        Payment configPayment = paymentRepository.findById(payment.getPaymentId()).orElse(null);
        if (configPayment != null) {
            payment = mergePayment(configPayment, payment);
        }
        paymentRepository.save(payment);
    }

    public void deletePayment(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    public Payment mergePayment(Payment configPayment, Payment newPayment) {
        if (StringUtils.isNotEmpty(newPayment.getBookingId())) {
            configPayment.setBookingId(newPayment.getBookingId());
        }
        if (newPayment.getPaymentDate() != null) {
            configPayment.setPaymentDate(newPayment.getPaymentDate());
        }
        if (newPayment.getPaymentAmount() != null) {
            configPayment.setPaymentAmount(newPayment.getPaymentAmount());
        }
        if (StringUtils.isNotEmpty(newPayment.getPaymentMethod())) {
            configPayment.setPaymentId(newPayment.getPaymentMethod());
        }
        return configPayment;
    }

}