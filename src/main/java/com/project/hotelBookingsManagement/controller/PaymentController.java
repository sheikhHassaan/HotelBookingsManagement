package com.project.hotelBookingsManagement.controller;

import com.project.hotelBookingsManagement.domain.Payment;
import com.project.hotelBookingsManagement.service.PaymentsServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel_bookings_management/payment")
public class PaymentController {

    PaymentsServiceImpl paymentService;

    @GetMapping("/list")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/get/{payment_id}")
    public Payment getPayment(@PathVariable("payment_id") String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping("/add")
    public void addPayment(@Validated @RequestBody Payment payment) {
        paymentService.addPayment(payment);
    }

    @PutMapping("/update/{payment_id}")
    public void updatePayment(@PathVariable("payment_id") String paymentId, @RequestBody Payment payment) {
        if (paymentId != null) {
            payment.setPaymentId(paymentId);
        }
        paymentService.updatePayment(payment);
    }

    @DeleteMapping("/remove/{payment_id}")
    public void removePayment(@PathVariable("payment_id") String paymentId) {
        paymentService.deletePayment(paymentId);
    }
}