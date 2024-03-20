package com.example.room_relish_api.repository;

import com.example.room_relish_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}