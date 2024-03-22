package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Payment;

public interface PaymentService {
    public Payment getPaymentDetails(String paymentID);
}
