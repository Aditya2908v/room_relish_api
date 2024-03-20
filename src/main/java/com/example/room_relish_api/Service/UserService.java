package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUser(String id);
}
