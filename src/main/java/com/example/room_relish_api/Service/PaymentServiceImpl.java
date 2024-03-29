package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Payment;
import com.example.room_relish_api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository)
    {
        this.paymentRepository=paymentRepository;
    }


    public Payment getPaymentDetails(String paymentId){
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        Payment payment1 = new Payment();
        if(payment.isPresent()){
            payment1=payment.get();
        }
        return payment1;
    }
}
