package com.example.room_relish_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "room_payments")
public class Payment {
    @Id
    private String id;
    private String _userId;
    private String _hotelId;
    private float totalAmount;


    public Payment(String _userId, String _hotelId, float totalAmount) {
        this._userId = _userId;
        this._hotelId = _hotelId;
        this.totalAmount = totalAmount;
    }
}
