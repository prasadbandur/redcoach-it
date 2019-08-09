package com.example.redcoach.domains.savepassenger.response;

import lombok.Data;

@Data
public class SavePassengerResponse {
    private String code;
    private String msg;
    private Request request;
}
