package com.example.redcoach.domains.travels.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelResponse {
    private int code;

    private String msg;

    private List<Data> data;

    //private Request request;
}
