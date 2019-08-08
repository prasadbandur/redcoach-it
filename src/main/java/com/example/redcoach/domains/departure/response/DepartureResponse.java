package com.example.redcoach.domains.departure.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartureResponse {
    private int code;

    private String msg;

    private List<Data> data;

    //private Request request;
}
