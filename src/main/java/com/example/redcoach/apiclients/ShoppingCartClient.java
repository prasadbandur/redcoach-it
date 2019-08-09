package com.example.redcoach.apiclients;

import com.example.redcoach.constants.ApiLoginDetails;
import com.example.redcoach.domains.shoppingcart.response.AddShoppingCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static com.example.redcoach.constants.ApiUrlConstants.BASE_PATH;

@Service
public class ShoppingCartClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<AddShoppingCartResponse> getAddShoppingCartResponseEntity(String cid, String departureId,
                                                                                 String arrivalId, String travelId, Boolean isRoundTrip,
                                                                                 Boolean direction, String baseFareTypeId, String multiPathDepartureId,
                                                                                    String multiPathArrivalId, LocalDate departureDate
                                                                                 , String shoppingCartId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("CID", cid);
        map.add("U_NAME", ApiLoginDetails.U_NAME);
        map.add("U_PASSWORD", ApiLoginDetails.PWD);
        map.add("ID_DEPARTURE", departureId);
        map.add("ID_ARRIVAL", arrivalId);
        map.add("ID_TRAVEL", travelId);
        map.add("TYPE_WAY", isRoundTrip ? "1": "0");
        map.add("DIRECTION", direction ? "1" : "0");
        map.add("ID_TYPEBASE_FARE", baseFareTypeId);
        map.add("ID_DEPARTURE_MR", multiPathDepartureId);
        map.add("ID_ARRIVAL_MR", multiPathArrivalId);

        //TODO: What to do for below mappings?
       // map.add("ID_SHU_DEP", departureDate.toString());
       // map.add("ID_SHU_ARR", departureDate.toString());
        map.add("ID_SHOPPING_CART", shoppingCartId);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        try {
            ResponseEntity<AddShoppingCartResponse> response = restTemplate.postForEntity(BASE_PATH + "/addShoppingCartByStep", request, AddShoppingCartResponse.class);
            return response;
        } catch (RestClientException e) {
            throw new RuntimeException("Exception caught while performing booking for travel");
        }
    }

}
