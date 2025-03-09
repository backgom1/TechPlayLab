package com.mylab.techLab.week7_testdouble.subject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardSubwayTime {

    @JsonProperty("list_total_count")
    private int listTotalCount;

    @JsonProperty("RESULT")
    private Result result;

    @JsonProperty("row")
    private List<SeoulSubwayDto> row;
}
