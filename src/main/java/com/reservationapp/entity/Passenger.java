package com.reservationapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;

    @Column(name = "bus_id")
    private long busId;

    @Column(name = "route_id")
    private long routeId;
//    private long subRouteId;

}
