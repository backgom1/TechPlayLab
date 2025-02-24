package com.mylab.techLab.week7_testdouble.subject;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SeoulSubwayRestClient {

    private static final String API_KEY = "123";

    public SubwayResponse getBoardingAlightingInfo(SeoulSubwayRequest request) {

        RestClient base = RestClient.builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/")
                .defaultHeader("Content-Type", "application/json")
                .build();

        return base.get()
                .uri("{KEY}/json/CardSubwayTime/{START_INDEX}/{END_INDEX}/{USE_MM}/{SBWY_ROUT_LN_NM}/{STTN}",
                        API_KEY, request.getStartIndex(), request.getEndIndex(), request.getStartDate(),
                        request.getLine(), request.getStationName())
                .retrieve()
                .body(SubwayResponse.class);
    }
}
