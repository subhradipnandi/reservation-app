package com.reservationapp.service;

import com.reservationapp.payload.PassengerDto;
import com.reservationapp.payload.ReservationDto;

public interface ReservationService {
    String bookTicket(long busId, long routeId, PassengerDto passengerDto);
}
