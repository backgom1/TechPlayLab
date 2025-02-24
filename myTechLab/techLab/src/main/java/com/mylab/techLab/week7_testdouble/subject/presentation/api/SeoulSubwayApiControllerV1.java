package com.mylab.techLab.week7_testdouble.subject.presentation.api;


import com.mylab.techLab.week7_testdouble.subject.SeoulSubwayRequest;
import com.mylab.techLab.week7_testdouble.subject.SubwayResponse;
import com.mylab.techLab.week7_testdouble.subject.presentation.application.service.SeoulSubwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SeoulSubwayApiControllerV1 {

    private final SeoulSubwayService seoulSubwayService;

    @PostMapping("/api/v1/subway")
    public SubwayResponse getSeoulSubway(@RequestBody SeoulSubwayRequest request) {
        return seoulSubwayService.getSubWayStatistics(request);
    }

}
