package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking bookRoom(Booking booking);
}
