package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchListOfBusesWithRoutesDto {

//    private Long busId;
//    private String busNo;
//    private String busType;
//    private double price;
//    private int totalSeats;
//    private int availableSeats;
//    private Long routeId;
//    private String fromLocation;
//    private String toLocation;
//    private String fromDate;
//    private String toDate;
//    private String totalDuration;
//    private String fromTime;
//    private String toTime;

    private BusDto busDto;
    private RouteDto routeDto;
}
