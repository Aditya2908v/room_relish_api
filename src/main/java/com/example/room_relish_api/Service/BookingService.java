package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Booking;
import com.example.room_relish_api.model.Payment;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Payment bookRoom(Payment payment);
    Booking payRoom(Payment payment);
}
