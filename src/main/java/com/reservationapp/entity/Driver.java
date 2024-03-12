package com.reservationapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String driverName;

    @Column(name = "licence_number", unique = true)
    private String driverLicenceNumber;

    private String addNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;

    private String emailId;

}

