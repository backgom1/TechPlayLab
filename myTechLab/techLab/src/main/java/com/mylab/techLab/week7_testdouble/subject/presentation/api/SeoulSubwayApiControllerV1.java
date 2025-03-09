package com.mylab.techLab.week7_testdouble.subject.presentation.api;


import com.mylab.techLab.week7_testdouble.subject.dto.request.SeoulSubwayRequest;
import com.mylab.techLab.week7_testdouble.subject.application.service.SeoulSubwayService;
import com.mylab.techLab.week7_testdouble.subject.dto.response.PassengerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SeoulSubwayApiControllerV1 {

    private final SeoulSubwayService seoulSubwayService;

    @PostMapping("/api/v1/subway")
    public List<PassengerResponse> getSeoulSubway(@RequestBody @Valid SeoulSubwayRequest request) {
        return seoulSubwayService.getPassengerCount(request);
    }

}
