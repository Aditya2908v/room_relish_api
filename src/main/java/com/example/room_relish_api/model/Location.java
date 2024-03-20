package com.example.room_relish_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String cityName;
    private Double latitude;
    private Double longitude;
    private String address;
}
