package com.example.room_relish_api.controller;

import com.example.room_relish_api.Service.HotelService;
import com.example.room_relish_api.model.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;

    }

    @QueryMapping("hotels")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @QueryMapping("hotel")
    public Optional<Hotel> getHotel(@Argument String id){
        return hotelService.getHotel(id);
    }

}
