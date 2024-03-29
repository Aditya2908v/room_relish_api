package com.example.room_relish_api.repository;

import com.example.room_relish_api.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}
