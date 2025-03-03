package com.mylab.techLab.week7_testdouble.subject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SeoulSubwayResultDto {

    @JsonProperty("RESULT")
    private Result result;
}
