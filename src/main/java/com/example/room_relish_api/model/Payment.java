package com.example.room_relish_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "room_payments")
public class Payment {
    @Id
    private String id;
    private String _userId;
    private String _hotelId;
    private String _roomId;
    private int numOfRooms;
    private int numOfDays;
    private float totalAmount;
    private float gstOfTotalAmount;
}
