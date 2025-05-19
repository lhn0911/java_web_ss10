package com.rikkei.ss10.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seat {
    private String seatNumber;
    private String seatType;
    private double price;
    private boolean selected;
}
