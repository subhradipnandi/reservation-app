package com.reservationapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {

    private long passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;
    private long busId;
    private long routeId;

}
