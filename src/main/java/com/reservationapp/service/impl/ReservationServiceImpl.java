package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Passenger;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.PassengerDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.PassengerRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.ReservationService;
import com.reservationapp.util.EmailService;
import com.reservationapp.util.PdfTicketGeneratorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private PdfTicketGeneratorService pdfTicketGeneratorService;

    @Autowired
    private EmailService emailService;

    @Override
    public String bookTicket(long busId, long routeId, PassengerDto passengerDto) {

        boolean busIsPresent = false;
        boolean routeIsPresent = false;
        boolean subRouteIsPresent = false;

        Optional<Bus> busById = busRepository.findById(busId);
        if(busById.isPresent()){
            busIsPresent = true;
            Bus bus = busById.get();
        }

        Route route = null;
        Optional<Route> routeById = routeRepository.findById(routeId);
        if(routeById.isPresent()){
            routeIsPresent = true;
            route = routeById.get();
        }

        SubRoute subRoute = null;
        Optional<SubRoute> subRouteById = subRouteRepository.findById(routeId);
        if(subRouteById.isPresent()){
            subRouteIsPresent = true;
            subRoute = subRouteById.get();
        }

        if(busIsPresent&&routeIsPresent || busIsPresent&&subRouteIsPresent){
            Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
            passenger.setBusId(busId);
            passenger.setRouteId(routeId);
            Passenger savedPassenger = passengerRepository.save(passenger);
            byte[] pdfBytes = null;
            if(routeIsPresent) {
                pdfBytes = pdfTicketGeneratorService.generateTicket(savedPassenger, route.getFromLocation(), route.getToLocation(), route.getFromDate(), route.getToDate());
            }
            if(subRouteIsPresent){
                pdfBytes = pdfTicketGeneratorService.generateTicket(savedPassenger, subRoute.getFromLocation(), subRoute.getToLocation(), subRoute.getFromDate(), subRoute.getToDate());
            }
            emailService.sendEmail(passenger.getEmail(),"Booking confirmed...", "Your reservation id "+savedPassenger.getPassengerId(), pdfBytes, "ticket");
        }

        return "done!!";
    }
}
