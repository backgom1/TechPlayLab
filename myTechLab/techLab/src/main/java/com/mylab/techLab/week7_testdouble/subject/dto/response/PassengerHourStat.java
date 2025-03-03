package com.mylab.techLab.week7_testdouble.subject.dto.response;

import lombok.Getter;

@Getter
public class PassengerHourStat {

    private final int time;
    private final int getPassengers;
    private final int offPassengers;
    private final String trafficStatus;

    public PassengerHourStat(int time, int getPassengers, int offPassengers, String trafficStatus) {
        this.time = time;
        this.getPassengers = getPassengers;
        this.offPassengers = offPassengers;
        this.trafficStatus = trafficStatus;
    }

}
