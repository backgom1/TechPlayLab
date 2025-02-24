package com.mylab.techLab.week7_testdouble.subject.presentation.application.service;

import com.mylab.techLab.week7_testdouble.subject.SeoulSubwayDto;
import com.mylab.techLab.week7_testdouble.subject.SeoulSubwayRequest;
import com.mylab.techLab.week7_testdouble.subject.SeoulSubwayRestClient;
import com.mylab.techLab.week7_testdouble.subject.SubwayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeoulSubwayService {

    private final SeoulSubwayRestClient restClient;

    public SubwayResponse getSubWayStatistics(SeoulSubwayRequest request) {
        return restClient.getBoardingAlightingInfo(request);
    }

}
