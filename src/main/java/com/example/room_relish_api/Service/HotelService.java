package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Hotel;
import com.example.room_relish_api.model.Room;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> getHotelsByCity(String cityName);
    List<Hotel> getAllHotels();

    Optional<Hotel> getHotel(String id);

    void saveRoom(Hotel hotel);
}
