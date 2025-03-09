package com.mylab.techLab.week7_testdouble.subject.dto.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PassengerResponse {
    private final String line;
    private final String stationName;
    private final String timestamp;
    private int maxPassengerHour;
    private int maxPassenger = 0;
    private final List<PassengerHourStat> passengerHours = new ArrayList<>();

    public PassengerResponse(String line, String stationName, String timestamp) {
        this.line = line;
        this.stationName = stationName;
        this.timestamp = timestamp;
    }

    public void addPassengerHourStat(HourData stat) {
        int totalPassenger = stat.getGetOn() + stat.getGetOff();

        if (totalPassenger > maxPassenger) {
            maxPassengerHour = stat.getHour();
            maxPassenger = totalPassenger;
        }

        if (totalPassenger > 1000) {
            this.passengerHours.add(new PassengerHourStat(stat.getHour(), stat.getGetOn(), stat.getGetOff(), "혼잡"));
        } else {
            this.passengerHours.add(new PassengerHourStat(stat.getHour(), stat.getGetOn(), stat.getGetOff(), "미 혼잡"));
        }
    }

}
