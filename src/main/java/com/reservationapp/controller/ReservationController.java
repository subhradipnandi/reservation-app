package com.reservationapp.controller;


import com.reservationapp.entity.Passenger;
import com.reservationapp.payload.PassengerDto;
import com.reservationapp.payload.ReservationDto;
import com.reservationapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    public ReservationDto bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
            PassengerDto passengerDto
    ){
        ReservationDto dto = reservationService.bookTicket(busId, routeId, passengerDto);

        return dto;
    }

}
