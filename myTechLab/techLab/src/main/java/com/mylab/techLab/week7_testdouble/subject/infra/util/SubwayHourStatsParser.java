package com.mylab.techLab.week7_testdouble.subject.infra.util;

import com.mylab.techLab.week7_testdouble.subject.dto.response.SeoulSubwayDto;
import com.mylab.techLab.week7_testdouble.subject.dto.response.HourData;

public class SubwayHourStatsParser {

    public static HourData[] parseHourStats(SeoulSubwayDto subway) {
        HourData[] hourData = new HourData[24];
        hourData[0] = new HourData(4, subway.getHr4GetOnNope(), subway.getHr4GetOffNope());
        hourData[1] = new HourData(5, subway.getHr5GetOnNope(), subway.getHr5GetOffNope());
        hourData[2] = new HourData(6, subway.getHr6GetOnNope(), subway.getHr6GetOffNope());
        hourData[3] = new HourData(7, subway.getHr7GetOnNope(), subway.getHr7GetOffNope());
        hourData[4] = new HourData(8, subway.getHr8GetOnNope(), subway.getHr8GetOffNope());
        hourData[5] = new HourData(9, subway.getHr9GetOnNope(), subway.getHr9GetOffNope());
        hourData[6] = new HourData(10, subway.getHr10GetOnNope(), subway.getHr10GetOffNope());
        hourData[7] = new HourData(11, subway.getHr11GetOnNope(), subway.getHr11GetOffNope());
        hourData[8] = new HourData(12, subway.getHr12GetOnNope(), subway.getHr12GetOffNope());
        hourData[9] = new HourData(13, subway.getHr13GetOnNope(), subway.getHr13GetOffNope());
        hourData[10] = new HourData(14, subway.getHr14GetOnNope(), subway.getHr14GetOffNope());
        hourData[11] = new HourData(15, subway.getHr15GetOnNope(), subway.getHr15GetOffNope());
        hourData[12] = new HourData(16, subway.getHr16GetOnNope(), subway.getHr16GetOffNope());
        hourData[13] = new HourData(17, subway.getHr17GetOnNope(), subway.getHr17GetOffNope());
        hourData[14] = new HourData(18, subway.getHr18GetOnNope(), subway.getHr18GetOffNope());
        hourData[15] = new HourData(19, subway.getHr19GetOnNope(), subway.getHr19GetOffNope());
        hourData[16] = new HourData(20, subway.getHr20GetOnNope(), subway.getHr20GetOffNope());
        hourData[17] = new HourData(21, subway.getHr21GetOnNope(), subway.getHr21GetOffNope());
        hourData[18] = new HourData(22, subway.getHr22GetOnNope(), subway.getHr22GetOffNope());
        hourData[19] = new HourData(23, subway.getHr23GetOnNope(), subway.getHr23GetOffNope());
        hourData[20] = new HourData(0, subway.getHr0GetOnNope(), subway.getHr0GetOffNope());
        hourData[21] = new HourData(1, subway.getHr1GetOnNope(), subway.getHr1GetOffNope());
        hourData[22] = new HourData(2, subway.getHr2GetOnNope(), subway.getHr2GetOffNope());
        hourData[23] = new HourData(3, subway.getHr3GetOnNope(), subway.getHr3GetOffNope());

        return hourData;
    }

    public static HourData getHourData(HourData[] hours, String filterHour) {
        int index = Integer.parseInt(filterHour) - 4;
        if (index <= 0) {
            index += 24;
        }
        return hours[index];
    }
}
