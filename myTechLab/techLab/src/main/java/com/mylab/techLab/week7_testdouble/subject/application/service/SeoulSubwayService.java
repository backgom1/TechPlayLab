package com.mylab.techLab.week7_testdouble.subject.application.service;

import com.mylab.techLab.week7_testdouble.subject.dto.request.SeoulSubwayRequest;
import com.mylab.techLab.week7_testdouble.subject.dto.response.*;
import com.mylab.techLab.week7_testdouble.subject.infra.client.SeoulSubwayRestClient;
import com.mylab.techLab.week7_testdouble.subject.infra.util.SubwayHourStatsParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeoulSubwayService {

    private final SeoulSubwayRestClient restClient;

    public List<PassengerResponse> getPassengerCount(SeoulSubwayRequest request) {
        SubwayResponse boardingAlightingInfo = restClient.getBoardingAlightingInfo(request);
        CardSubwayTime cardSubwayTime = boardingAlightingInfo.getCardSubwayTime();
        List<SeoulSubwayDto> timeRows = cardSubwayTime.getRow();
        List<PassengerResponse> results = new ArrayList<>();

        for (SeoulSubwayDto timeRow : timeRows) {
            PassengerResponse response = new PassengerResponse(timeRow.getSbwyRoutLnNm(), timeRow.getSttn(), timeRow.getUseMm());
            HourData[] hourData = SubwayHourStatsParser.parseHourStats(timeRow);
            if (request.getFilterHour() != null) {
                HourData data = SubwayHourStatsParser.getHourData(hourData, request.getFilterHour());
                response.addPassengerHourStat(data);
            } else {
                for (HourData hour : hourData) {
                    response.addPassengerHourStat(hour);
                }
            }
            results.add(response);
        }
        return results;
    }

}
