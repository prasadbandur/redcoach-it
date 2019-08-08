package com.example.redcoach.apiclients;

import com.example.redcoach.constants.ApiLoginDetails;
import com.example.redcoach.domains.arrivals.response.ArrivalResponse;
import com.example.redcoach.domains.travels.response.TravelResponse;
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
import java.util.Date;

import static com.example.redcoach.constants.ApiUrlConstants.BASE_PATH;

@Service
public class GetTravelsClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<TravelResponse> getTravelResponseEntity(String cid, String departureId,
                                                                  String arrivalId, LocalDate departureDate,
                                                                  Boolean isRoundTrip, LocalDate arrivalDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("CID", cid);
        map.add("U_NAME", ApiLoginDetails.U_NAME);
        map.add("U_PASSWORD", ApiLoginDetails.PWD);
        map.add("ID_DEPARTURE", departureId);
        map.add("ID_ARRIVAL", arrivalId);
        map.add("DATE_DEPARTURE", departureDate.toString());
        map.add("TYPE_WAY", isRoundTrip ? "1": "0");
        map.add("DATE_RETURN", arrivalDate == null ? null : arrivalDate.toString());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        try {
            ResponseEntity<TravelResponse> response = restTemplate.postForEntity(BASE_PATH + "/getTravels", request, TravelResponse.class);
            return response;
        } catch (RestClientException e) {
            throw new RuntimeException("Exception caught while performing search for arrivals");
        }
    }

}
