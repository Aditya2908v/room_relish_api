package com.example.room_relish_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String email;
    private String googleId;
    private List<String> favouriteHotels;
    private List<String> recentVisitsOfHotels;
    private Date registeredAt;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String profilePicture;
    private String coverPicture;
}
