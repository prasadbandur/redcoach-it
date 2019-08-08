package com.example.redcoach.domains.travels.response;

import lombok.Data;

import java.util.List;

@Data
public class Fare {
    private String fareId;
    private String name;
    private String have_limit;
    private String limit;
    private String ttype;
    private String price;
    private String pWinTrip;
    private String pPayTrip;
    private List<PriceByTicketType> priceByTicketType;

}
