package com.reservationapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long routeId;

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

    @Column(name = "bus_id", unique = true, nullable = false)
    private long busId;

//    @OneToOne
//    @JoinColumn(name = "bus_id", referencedColumnName = "routeId")
//    private Bus bus;
//
//    @OneToMany(mappedBy = "route")
//    private List<SubRoute> subRoutes;

}
