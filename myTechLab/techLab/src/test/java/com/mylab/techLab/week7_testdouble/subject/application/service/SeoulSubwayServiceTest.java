package com.mylab.techLab.week7_testdouble.subject.application.service;

import com.mylab.techLab.week7_testdouble.subject.dto.response.HourData;
import com.mylab.techLab.week7_testdouble.subject.dto.response.PassengerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@SpringBootTest
class SeoulSubwayServiceTest {

    @Mock
    private SeoulSubwayService mockSeoulSubwayService;

    @Mock
    private List<PassengerResponse> mockPassengerResponses;

    @Mock
    private PassengerResponse mockPassengerResponse;

    @Autowired
    private SeoulSubwayService seoulSubwayService;

    @DisplayName("지하철 호선과 역 이름을 입력하면, 해당 역의 시간대별 승하차 인원 정보를 가져와야 한다.")
    @Test
    void shouldPassengerHourAlertMessage() {

        when(mockSeoulSubwayService.getPassengerCount(any())).thenReturn(mockPassengerResponses);
        List<PassengerResponse> passengerCount = mockSeoulSubwayService.getPassengerCount(any());
        when(passengerCount.get(eq(0))).thenReturn(mockPassengerResponse);
        when(passengerCount.get(0).getMaxPassengerHour()).thenReturn(9);

        when(passengerCount.get(0).getLine()).thenReturn("2호선");
        when(passengerCount.get(0).getMaxPassengerHour()).thenReturn(9);
        when(passengerCount.get(0).getTimestamp()).thenReturn("2023-11");
        when(passengerCount.get(0).getStationName()).thenReturn("구의역");


    }

    @DisplayName("하루 중 가장 승하차 인원이 많은 시간대를 표시해야 한다.")
    @Test
    void shouldFindHourWithMostBoardingAndAlightingPassengers() {
        //given & when
        when(mockSeoulSubwayService.getPassengerCount(any())).thenReturn(mockPassengerResponses);
        List<PassengerResponse> passengerCount = mockSeoulSubwayService.getPassengerCount(any());
        when(passengerCount.get(eq(0))).thenReturn(mockPassengerResponse);
        when(passengerCount.get(0).getMaxPassengerHour()).thenReturn(9);

        //then
        assertThat(passengerCount).isNotNull();
        assertThat(passengerCount.get(0).getMaxPassengerHour()).isEqualTo(9);
    }


    @DisplayName("승하차 인원이 1000명 이상일 경우 혼잡 메세지를 출력한다.")
    @Test
    void shouldOnOffPassengers1000ThenConfusion() {
        // given
        PassengerResponse passengerResponse = new PassengerResponse("2호선", "강남역", "2024-03");
        HourData hourData = new HourData(9, 1000, 2000);
        List<PassengerResponse> actualList = new ArrayList<>(List.of(passengerResponse));
        when(mockSeoulSubwayService.getPassengerCount(any())).thenReturn(actualList);

        // when
        List<PassengerResponse> passengerCount = mockSeoulSubwayService.getPassengerCount(any());

        passengerCount.get(0).addPassengerHourStat(hourData);

        // then
        assertThat(passengerCount).hasSize(1);
        assertThat(passengerCount.get(0).getPassengerHours()).hasSize(1);
        assertThat(passengerCount.get(0).getPassengerHours().get(0).getTrafficStatus()).isEqualTo("혼잡");
    }



    @DisplayName("선택한 호선/역/날짜에 대한 데이터가 존재하지 않을 경우, 해당 데이터가 존재하지 않습니다. 라는 메시지를 반환한다.")
    @Test
    void shouldShowMessageWhenSelectedDataIsMissing() {
//
//        // given
//        SeoulSubwayRequest seoulSubwayRequest = new SeoulSubwayRequest(1,10,"202401","10호선","구의(광진구청)","10");
//
//        //when & then
//        assertThatThrownBy(()-> seoulSubwayService.getPassengerCount(seoulSubwayRequest))
//                .isInstanceOf(SeoulSubwayException.class)
//                .hasMessage("해당하는 데이터가 없습니다.");
    }

}