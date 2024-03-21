package com.example.room_relish_api.repository;

import com.example.room_relish_api.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
