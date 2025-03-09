package com.mylab.techLab.week7_testdouble.subject.application.service;

import com.mylab.techLab.week7_testdouble.subject.dto.request.SeoulSubwayRequest;
import com.mylab.techLab.week7_testdouble.subject.dto.response.*;
import com.mylab.techLab.week7_testdouble.subject.infra.client.SeoulSubwayRestClient;
import com.mylab.techLab.week7_testdouble.subject.presentation.exception.SeoulSubwayException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class SeoulSubwayServiceTest {

    @Mock
    private SeoulSubwayRestClient restClient;

    @Mock
    private SubwayResponse mockSubwayResponse;

    @Mock
    private CardSubwayTime mockCardSubwayTime;

    @InjectMocks
    private SeoulSubwayService seoulSubwayService;


    @DisplayName("하루 중 가장 승하차 인원이 많은 시간대를 표시해야 한다.")
    @Test
    void shouldFindHourWithMostBoardingAndAlightingPassengers() {
        // given
        SeoulSubwayRequest request = new SeoulSubwayRequest(1, 2, "2024-03", "2호선", "강남역", "10");
        List<SeoulSubwayDto> mockTimeRows = List.of(init());

        //stubbing
        when(restClient.getBoardingAlightingInfo(any())).thenReturn(mockSubwayResponse);
        when(mockSubwayResponse.getCardSubwayTime()).thenReturn(mockCardSubwayTime);
        when(mockCardSubwayTime.getRow()).thenReturn(mockTimeRows);

        // when
        List<PassengerResponse> results = seoulSubwayService.getPassengerCount(request);

        // then
        assertThat(results).isNotNull();
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getLine()).isEqualTo("2호선");
        assertThat(results.get(0).getStationName()).isEqualTo("강남역");
        verify(restClient,times(1)).getBoardingAlightingInfo(any(SeoulSubwayRequest.class));
    }

    private SeoulSubwayDto init() {
        return new SeoulSubwayDto(
                "2024-03",   // useMm
                "2호선",     // sbwyRoutLnNm
                "강남역",     // sttn
                "20240315",  // jobYmd

                // 시간대별 승하차 인원 (예제 데이터)
                500, 300,   // 4시
                600, 400,   // 5시
                700, 500,   // 6시
                900, 700,   // 7시
                1200, 1100, // 8시
                1500, 1400, // 9시
                800, 700,   // 10시
                750, 600,   // 11시
                700, 500,   // 12시
                650, 450,   // 13시
                600, 400,   // 14시
                550, 350,   // 15시
                500, 300,   // 16시
                450, 250,   // 17시
                400, 200,   // 18시
                350, 150,   // 19시
                300, 100,   // 20시
                250, 80,    // 21시
                200, 60,    // 22시
                150, 50,    // 23시
                100, 40,    // 0시
                80, 30,     // 1시
                60, 20,     // 2시
                40, 10      // 3시
        );
    }


    @DisplayName("승하차 인원이 1000명 이상일 경우 혼잡 메세지를 출력한다.")
    @Test
    void shouldOnOffPassengers1000ThenConfusion() {
        // given
        PassengerResponse passengerResponse = new PassengerResponse("2호선", "강남역", "2024-03");
        HourData hourData = new HourData(9, 1000, 2000);
        List<PassengerResponse> actualList = new ArrayList<>(List.of(passengerResponse));
        when(seoulSubwayService.getPassengerCount(any())).thenReturn(actualList);

        // when
        List<PassengerResponse> passengerCount = seoulSubwayService.getPassengerCount(any());

        passengerCount.get(0).addPassengerHourStat(hourData);

        // then
        assertThat(passengerCount).hasSize(1);
        assertThat(passengerCount.get(0).getPassengerHours()).hasSize(1);
        assertThat(passengerCount.get(0).getPassengerHours().get(0).getTrafficStatus()).isEqualTo("혼잡");
    }


    @DisplayName("선택한 호선/역/날짜에 대한 데이터가 존재하지 않을 경우, 해당 데이터가 존재하지 않습니다. 라는 메시지를 반환한다.")
    @Test
    void shouldShowMessageWhenSelectedDataIsMissing() {
        // given
        SeoulSubwayRequest seoulSubwayRequest = new SeoulSubwayRequest(1, 10, "202401", "10호선", "구의(광진구청)", "10");

        //when & then
        assertThatThrownBy(() -> seoulSubwayService.getPassengerCount(seoulSubwayRequest))
                .isInstanceOf(SeoulSubwayException.class)
                .hasMessage("해당하는 데이터가 없습니다.");
    }

}