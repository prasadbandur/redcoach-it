package com.example.redcoach.domains.travels.response;

import java.util.List;

@lombok.Data
public class Data {
    private List<Travel> ow;
    private List<Travel> rw;
    private String idDepartureRoute;
    private String idDepartureNear;
    private String idArrivalRoute;
    private String idArrivalNear;
    private String departureName;
    private String arrivalName;
    private String maxPassengers;
}
