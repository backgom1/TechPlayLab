package com.mylab.techLab.week7_testdouble.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SubwayResponse {

    @JsonProperty("CardSubwayTime")
    private CardSubwayTime cardSubwayTime;
}
