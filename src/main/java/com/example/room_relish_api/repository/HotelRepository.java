package com.example.room_relish_api.repository;

import com.example.room_relish_api.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}