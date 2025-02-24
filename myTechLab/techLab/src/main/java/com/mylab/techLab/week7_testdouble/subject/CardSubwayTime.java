package com.mylab.techLab.week7_testdouble.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class CardSubwayTime {

    @JsonProperty("list_total_count")
    private int listTotalCount;

    @JsonProperty("RESULT")
    private Result result;

    @JsonProperty("row")
    private List<SeoulSubwayDto> row;
}
