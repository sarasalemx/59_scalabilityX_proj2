package com.example.demo.services;

import com.example.demo.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // 8.4.2.1 Add Payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // 8.4.2.2 Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // 8.4.2.3 Get Payment By ID
    public Payment getPaymentById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null); // or throw custom NotFoundException
    }

    // 8.4.2.4 Update Payment
    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setAmount(updatedPayment.getAmount());
            payment.setPaymentMethod(updatedPayment.getPaymentMethod());
            payment.setPaymentStatus(updatedPayment.getPaymentStatus());
            payment.setTrip(updatedPayment.getTrip());
            return paymentRepository.save(payment);
        }).orElse(null); // or throw custom NotFoundException
    }

    // 8.4.2.5 Delete Payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    // 8.4.2.6 Find Payments By Trip ID
    public List<Payment> findPaymentsByTripId(Long tripId) {
        return paymentRepository.findByTripId(tripId);
    }

    // 8.4.2.7 Find Payments With an Amount Greater Than a Threshold
    public List<Payment> findByAmountThreshold(Double threshold) {
        return paymentRepository.findByAmountGreaterThan(threshold);
    }
}

