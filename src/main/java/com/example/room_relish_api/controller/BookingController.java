package com.example.room_relish_api.controller;

import com.example.room_relish_api.Service.BookingService;
import com.example.room_relish_api.model.Booking;
import com.example.room_relish_api.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookHotelRoom(@RequestBody Payment payment){
        try{
            return new ResponseEntity<>(bookingService.bookRoom(payment), HttpStatus.OK);
        }catch (IllegalArgumentException | NullPointerException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/pay")
    public ResponseEntity<?> paymentProcess(@RequestBody Payment payment){
        try{
            return new ResponseEntity<>(bookingService.payRoom(payment), HttpStatus.OK);
        }
        catch(IllegalArgumentException | NullPointerException ae){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ae.getMessage());
        }
    }


}
