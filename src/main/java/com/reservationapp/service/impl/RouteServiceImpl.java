package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.exception.ResourceNotFoundException;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;

    @Override
    public Route addRoute(long busId, Route route) {

        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFoundException("Bus not added")
        );

        Route r = routeRepository.findByBusId(route.getBusId());

        if(r != null){
            throw new ResourceNotFoundException("Route was already added!!");
        }

        if(r == null){
            routeRepository.save(route);
            return route;
        }
        return null;
    }
}
