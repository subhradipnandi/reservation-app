package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.exception.ResourceNotFoundException;
import com.reservationapp.payload.PassengerDto;
import com.reservationapp.payload.ReservationDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Override
    public ReservationDto bookTicket(long busId, long routeId, PassengerDto passengerDto) {

        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        boolean subRouteIsPresent = false;

        Optional<Bus> busById = busRepository.findById(busId);
        if(busById.isPresent()){
            busIsPresent = true;
            Bus bus = busById.get();
        }

        Optional<Route> routeById = routeRepository.findById(routeId);
        if(routeById.isPresent()){
            routeIsPresent = true;
            Route route = routeById.get();
        }

        Optional<SubRoute> subRouteById = subRouteRepository.findById(routeId);
        if(subRouteById.isPresent()){
            subRouteIsPresent = true;
            SubRoute subRoute = subRouteById.get();
        }

        if(busIsPresent&&routeIsPresent || busIsPresent&&subRouteIsPresent){

        }

        return null;
    }
}
