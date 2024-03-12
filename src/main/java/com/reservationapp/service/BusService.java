package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SearchListOfBusesWithRoutesDto;
import com.reservationapp.payload.SearchListOfBusesWithSubRoutesDto;

import java.util.List;

public interface BusService {
    public Bus addBuss(BusDto busDto);

    List<?> getAllBusses(String fromLocation, String toLocation, String fromDate);
}
