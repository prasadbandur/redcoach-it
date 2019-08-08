package com.example.redcoach.domains.travels.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Travel {
    private String travelId;
    private String travelCode;
    private String travelService;
    private String travelTime;
    private String travelRouteName;
    private String travelDepartureDatetime;
    private String travelArrivalDatetime;
    private String travelRouteId;
    private String free;
    private String symbol;
    private String priceByGroupSeat;
    private String discountByTT;
    private List<Fare> fare;
    private BigDecimal available;
}
