package com.example.redcoach.apiclients;

import com.example.redcoach.domains.arrivals.response.ArrivalResponse;
import com.example.redcoach.domains.departure.response.DepartureResponse;
import com.example.redcoach.domains.travels.response.TravelResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RecoachApiTest {

    @Autowired
    private DepartureClient departureClient;

    @Autowired
    private ArrivalClient arrivalClient;

    @Autowired
    private GetTravelsClient getTravelsClient;

    @Test
    void testDepartures() {
        String cid = "someUser1";
        ResponseEntity<DepartureResponse> departureResponseEntity = departureClient.getDepartureResponseEntity(cid);
        DepartureResponse departureResponse = departureResponseEntity.getBody();
        System.out.println("departureResponseEntity.getBody() ===> "+ departureResponse);
        departureResponse.getData().forEach(departure -> {
            ResponseEntity<ArrivalResponse> arrivalResponseEntity = arrivalClient.getArrivalResponseEntity(cid, departure.getId());
            ArrivalResponse arrivalResponse = arrivalResponseEntity.getBody();
            System.out.println("arrivalResponse ===> "+arrivalResponse);

            arrivalResponse.getData().forEach(arrival -> {
                ResponseEntity<TravelResponse> travelResponseEntity = getTravelsClient.getTravelResponseEntity(cid, departure.getId(), arrival.getId(), LocalDate.of(2019, 8, 22), Boolean.FALSE, null);
                System.out.println("travelResponseEntity ===> "+travelResponseEntity);
            });
        });
    }
}
