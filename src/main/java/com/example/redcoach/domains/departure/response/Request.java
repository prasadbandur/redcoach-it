package com.example.redcoach.domains.departure.response;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Request {
    @JsonProperty(value = "CID")
    private String cid;

    @JsonProperty(value = "U_NAME")
    private String uName;

    @JsonProperty(value = "U_PASSWORD")
    private String uPassword;
}
