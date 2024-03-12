package com.reservationapp.service.impl;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.*;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import com.reservationapp.service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Override
    public Bus addBuss(BusDto busDto) {

        Bus bus = mapToEntity(busDto);

        Bus savedBus = busRepository.save(bus);

        return savedBus;

    }

    @Override
    public List<?> getAllBusses(String fromLocation, String toLocation, String fromDate) {
        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);

        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);

        List busesDtos = new ArrayList<>();
        if(routes != null) {
            for (Route route : routes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                busesDtos.add(mapToSearchListOfBusesWithRoutesDto(bus, route));
            }
            return busesDtos;
        }

        if(subRoutes != null){
            for(SubRoute subRoute : subRoutes){
                Bus bus = busRepository.findById(subRoute.getBusId()).get();
                busesDtos.add(mapToSearchListOfBusesWithSubRoutesDto(bus, subRoute));
            }
            return busesDtos;
        }
        return null;
    }

    public Bus mapToEntity(BusDto dto){
        return modelMapper.map(dto, Bus.class);
    }

    public BusDto mapToDto(Bus bus){
        BusDto dto = modelMapper.map(bus, BusDto.class);
        return dto;
    }

    SearchListOfBusesWithRoutesDto mapToSearchListOfBusesWithRoutesDto(Bus bus, Route route){
        BusDto busDto = modelMapper.map(bus, BusDto.class);
        RouteDto routeDto = modelMapper.map(route, RouteDto.class);

        SearchListOfBusesWithRoutesDto dto = new SearchListOfBusesWithRoutesDto();
        dto.setBusDto(busDto);
        dto.setRouteDto(routeDto);

        return dto;
    }

    SearchListOfBusesWithSubRoutesDto mapToSearchListOfBusesWithSubRoutesDto(Bus bus, SubRoute subRoute){
        BusDto busDto = modelMapper.map(bus, BusDto.class);
        SubRouteDto subRouteDto = modelMapper.map(subRoute, SubRouteDto.class);

        SearchListOfBusesWithSubRoutesDto dto = new SearchListOfBusesWithSubRoutesDto();
        dto.setBusDto(busDto);
        dto.setSubRouteDto(subRouteDto);

        return dto;
    }

}
