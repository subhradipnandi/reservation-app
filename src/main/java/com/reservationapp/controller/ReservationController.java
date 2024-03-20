package com.reservationapp.controller;


import com.reservationapp.entity.Passenger;
import com.reservationapp.payload.PassengerDto;
import com.reservationapp.payload.ReservationDto;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.service.ReservationService;
import com.reservationapp.util.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping
    public ResponseEntity<String> bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
            @RequestBody PassengerDto passengerDto
    ){
        String msg = reservationService.bookTicket(busId, routeId, passengerDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

    @GetMapping
    public ResponseEntity<byte[]> generateExcel(){
        try {
            List<Passenger> passengers = passengerRepository.findAll();
            byte[] excelBytes = excelService.generateExcel(passengers);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "passenger_data.xlsx");
            return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
