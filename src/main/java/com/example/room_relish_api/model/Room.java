package com.example.room_relish_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String id;
    private String roomType;
    private String roomSpecification;
    private int roomRate;
    private int roomCount;
}
