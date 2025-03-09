package com.mylab.techLab.week7_testdouble.subject.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SeoulSubwayRequest {
    private int startIndex;
    private int endIndex;
    private String startDate;
    private String line;
    private String stationName;
    private String filterHour;

    public SeoulSubwayRequest(int startIndex, int endIndex, String startDate, String line, String stationName, String filterHour) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.startDate = startDate;
        this.line = line;
        this.stationName = stationName;
        this.filterHour = filterHour;
    }
}
