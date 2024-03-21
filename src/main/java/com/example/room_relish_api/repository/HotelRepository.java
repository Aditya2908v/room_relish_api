package com.example.room_relish_api.repository;

import com.example.room_relish_api.model.Hotel;
import com.example.room_relish_api.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}