package com.mylab.techLab.week7_testdouble.subject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubwayResponse {
    @JsonProperty("CardSubwayTime")
    private CardSubwayTime cardSubwayTime;
}
