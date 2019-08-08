package com.example.redcoach.apiclients;

import com.example.redcoach.constants.ApiLoginDetails;
import com.example.redcoach.domains.arrivals.response.ArrivalResponse;
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

import static com.example.redcoach.constants.ApiUrlConstants.BASE_PATH;

@Service
public class ArrivalClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<ArrivalResponse> getArrivalResponseEntity(String cid, String departureId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("CID", cid);
        map.add("U_NAME", ApiLoginDetails.U_NAME);
        map.add("U_PASSWORD", ApiLoginDetails.PWD);
        map.add("ID_DEPARTURE", departureId);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        try {
            ResponseEntity<ArrivalResponse> response = restTemplate.postForEntity(BASE_PATH + "/getArrivals", request, ArrivalResponse.class);
            return response;
        } catch (RestClientException e) {
            throw new RuntimeException("Exception caught while performing search for arrivals");
        }
    }
}
