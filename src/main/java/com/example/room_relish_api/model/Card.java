package com.example.room_relish_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    private String id;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;
    private String cardName;
}
