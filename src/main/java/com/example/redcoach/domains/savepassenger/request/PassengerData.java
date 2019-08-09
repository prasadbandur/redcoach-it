package com.example.redcoach.domains.savepassenger.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PassengerData {
    @JsonProperty(value = "FIRST_NAME")
    private String firstName;

    @JsonProperty(value = "LAST_NAME")
    private String lastName;

    @JsonProperty(value = "ID_TICKET_TYPE")
    private String idTicketType;

    @JsonProperty(value = "PHONE")
    private String phone;

    @JsonProperty(value = "DATE_BIRTHDAY")
    private LocalDate birthDate;

    @JsonProperty(value = "EMAIL")
    private String email;

    @JsonProperty(value = "SEX")
    private String sex;

    @JsonProperty(value = "CID")
    private String DOC_TYPE;

    @JsonProperty(value = "DOC_NUM")
    private String docNumber;

    @JsonProperty(value = "C_LUGGAGE")
    private String carryLuggage;
}
