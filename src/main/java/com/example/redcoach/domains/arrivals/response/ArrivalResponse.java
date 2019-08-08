package com.example.redcoach.domains.arrivals.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrivalResponse {
    private int code;

    private String msg;

    private List<Data> data;

    //private Request request;
}
