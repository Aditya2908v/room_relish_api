package com.example.room_relish_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;
    private String _hotelId;
    private String _userId;
    private String _roomId;
    private String _paymentId;
    private int numOfRooms;
    private int numOfDays;

    public Booking(String _hotelId, String _userId, String _roomId, String _paymentId, int numOfRooms, int numOfDays, Boolean paymentStatus) {
        this._hotelId = _hotelId;
        this._userId = _userId;
        this._roomId = _roomId;
        this._paymentId = _paymentId;
        this.numOfRooms = numOfRooms;
        this.numOfDays = numOfDays;
        this.paymentStatus = paymentStatus;
    }

    private Boolean paymentStatus;
}
