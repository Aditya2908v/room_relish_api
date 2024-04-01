package com.example.room_relish_api.controller;

import com.example.room_relish_api.Service.UserService;
import com.example.room_relish_api.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRESTController {
    private final UserService userService;

    public UserRESTController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try{
            return new ResponseEntity<>(userService.loginData(user), HttpStatus.OK);
        }
        catch(IllegalArgumentException | NullPointerException ae){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ae.getMessage());
        }    }
}
