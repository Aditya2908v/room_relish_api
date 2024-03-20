package com.example.room_relish_api.controller;

import com.example.room_relish_api.Service.UserService;
import com.example.room_relish_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @QueryMapping("users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @QueryMapping("user")
    public Optional<User> getUser(@Argument String id){
        return userService.getUser(id);
    }
}
