package com.example.redcoach.domains.travels.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceByTicketType {
    private String idTicketType;
    private String name;
    private BigDecimal price;
}
