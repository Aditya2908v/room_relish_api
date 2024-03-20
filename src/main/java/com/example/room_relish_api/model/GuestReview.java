package com.example.room_relish_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestReview {
    @Id
    private String id;
    private String userId;
    private double guestRating;
    private String comment;
}
