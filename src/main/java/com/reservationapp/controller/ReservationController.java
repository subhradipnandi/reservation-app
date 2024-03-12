package com.reservationapp.controller;


import com.reservationapp.entity.Passenger;
import com.reservationapp.payload.PassengerDto;
import com.reservationapp.payload.ReservationDto;
import com.reservationapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<String> bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
            @RequestBody PassengerDto passengerDto
    ){
        String msg = reservationService.bookTicket(busId, routeId, passengerDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

}
