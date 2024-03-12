package com.reservationapp.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubRouteDto {

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
    private long routeId;
    private long busId;

    // getters, setters, and other constructors...
}

