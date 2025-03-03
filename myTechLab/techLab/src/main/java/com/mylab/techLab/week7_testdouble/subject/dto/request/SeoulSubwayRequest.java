package com.mylab.techLab.week7_testdouble.subject.dto.request;

import lombok.Getter;

@Getter
public class SeoulSubwayRequest {
    private int startIndex;
    private int endIndex;
    private String startDate;
    private String line;
    private String stationName;
    private String filterHour;

}
