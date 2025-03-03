package com.mylab.techLab.week7_testdouble.subject.dto.response;

import lombok.Getter;

@Getter
public class HourData {
    private final int hour;
    private final int getOn;
    private final int getOff;

    public HourData(int hour, int getOn, int getOff) {
        this.hour = hour;
        this.getOn = getOn;
        this.getOff = getOff;
    }
}
