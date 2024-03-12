package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SearchListOfBusesWithRoutesDto;
import com.reservationapp.payload.SearchListOfBusesWithSubRoutesDto;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@Valid @RequestBody BusDto busDto) /*throws ParseException*/ {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
//        Date fromDate = formatter.parse(busDto.getFromDate());
//        Date toDate = formatter.parse(busDto.getToDate());

        Bus bus = busService.addBuss(busDto);

        return new ResponseEntity<>(bus, HttpStatus.CREATED);

    }

    @GetMapping
    public List<?> getAllBusses(
            @RequestParam String fromLocation,
            @RequestParam String toLocation,
            @RequestParam String fromDate
    ){
        List<?> listOfBuses = busService.getAllBusses(fromLocation, toLocation, fromDate);
        return listOfBuses;
    }

}
