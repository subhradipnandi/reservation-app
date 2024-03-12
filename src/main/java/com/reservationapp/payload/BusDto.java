package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDto {

    private long busId;
    private String busNo;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;

//    private RouteDto route;

    // getters, setters, and other constructors...
}
