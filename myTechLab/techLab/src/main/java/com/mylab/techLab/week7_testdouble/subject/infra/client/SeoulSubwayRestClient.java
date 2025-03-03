package com.mylab.techLab.week7_testdouble.subject.infra.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylab.techLab.week7_testdouble.subject.dto.response.SubwayResponse;
import com.mylab.techLab.week7_testdouble.subject.presentation.exception.SeoulSubwayException;
import com.mylab.techLab.week7_testdouble.subject.dto.request.SeoulSubwayRequest;
import com.mylab.techLab.week7_testdouble.subject.dto.response.SeoulSubwayResultDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SeoulSubwayRestClient {

    @Value("${seoul.api}")
    private String apiKey;

    public SubwayResponse getBoardingAlightingInfo(SeoulSubwayRequest request) {

        ObjectMapper objectMapper = new ObjectMapper();

        RestClient base = RestClient.builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/")
                .defaultHeader("Content-Type", "application/json")
                .build();

        String body = base.get()
                .uri("{KEY}/json/CardSubwayTime/{START_INDEX}/{END_INDEX}/{USE_MM}/{SBWY_ROUT_LN_NM}/{STTN}",
                        apiKey, request.getStartIndex(), request.getEndIndex(), request.getStartDate(),
                        request.getLine(), request.getStationName())
                .retrieve()
                .body(String.class);

        try {
            return objectMapper.readValue(body, SubwayResponse.class);
        } catch (JsonProcessingException e) {
            try {
                SeoulSubwayResultDto result = objectMapper.readValue(body, SeoulSubwayResultDto.class);
                throw new SeoulSubwayException(result);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
