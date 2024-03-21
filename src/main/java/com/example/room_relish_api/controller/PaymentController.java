package com.example.room_relish_api.controller;

import com.example.room_relish_api.model.Payment;
import com.example.room_relish_api.repository.PaymentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping("/{paymentId}")
    public Optional<Payment> getPayment(@PathVariable String paymentId){
        return paymentRepository.findById(paymentId);
    }
}
