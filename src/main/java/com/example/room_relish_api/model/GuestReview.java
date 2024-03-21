package com.example.room_relish_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestReview {

    private String id;
    private String user;
    private String guestRating;
    private String comment;
}
