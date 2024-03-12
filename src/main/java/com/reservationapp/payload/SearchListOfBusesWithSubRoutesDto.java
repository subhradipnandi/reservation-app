package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchListOfBusesWithSubRoutesDto {

    private BusDto busDto;
    private SubRouteDto subRouteDto;

}
