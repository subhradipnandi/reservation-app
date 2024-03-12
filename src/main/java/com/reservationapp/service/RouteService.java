package com.reservationapp.service;

import com.reservationapp.entity.Route;

public interface RouteService {
    Route addRoute(long busId, Route route);
}
