package com.example.redcoach.domains.savepassenger.response;

import com.example.redcoach.domains.savepassenger.request.PassengerData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Request {
    @JsonProperty(value = "CID")
    private String cid;

    @JsonProperty(value = "U_NAME")
    private String uName;

    @JsonProperty(value = "U_PASSWORD")
    private String uPassword;

    @JsonProperty(value = "ID_SHOPPING_CART")
    private String shoppingCartId;

    @JsonProperty(value = "A_DATA")
    private List<PassengerData> passengers;
}
