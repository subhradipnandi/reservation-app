package com.reservationapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_routes")
public class SubRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subRouteId;

    private String fromLocation;
    private String toLocation;

//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private String fromDate;

//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private String toDate;

    private String totalDuration;
    private String fromTime;
    private String toTime;

    @Column(name = "route_id", nullable = false)
    private long routeId;

    @Column(name = "bus_id", unique = true, nullable = false)
    private long busId;

//    @ManyToOne
//    @JoinColumn(name = "route_id")
//    private Route route;


}
