package com.example.redcoach.apiclients;

import com.example.redcoach.constants.ApiLoginDetails;
import com.example.redcoach.domains.savepassenger.request.PassengerData;
import com.example.redcoach.domains.savepassenger.response.SavePassengerResponse;
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

import java.util.List;

import static com.example.redcoach.constants.ApiUrlConstants.BASE_PATH;

@Service
public class SavePassengerClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<SavePassengerResponse> getAddShoppingCartResponseEntity(String cid, String shoppingCartId, List<PassengerData> passengers) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
        map.add("CID", cid);
        map.add("U_NAME", ApiLoginDetails.U_NAME);
        map.add("U_PASSWORD", ApiLoginDetails.PWD);
        map.add("ID_SHOPPING_CART", shoppingCartId);
        map.add("A_DATA", passengers);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        try {
            ResponseEntity<SavePassengerResponse> response = restTemplate.postForEntity(BASE_PATH + "/savePassenger", request, SavePassengerResponse.class);
            return response;
        } catch (RestClientException e) {
            throw new RuntimeException("Exception caught while performing save passenger information for travel");
        }
    }

}
