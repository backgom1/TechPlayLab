package com.mylab.techLab.week7_testdouble.subject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SeoulSubwayRestClientTest {

    @Mock
    private SeoulSubwayRestClient client;

    @Mock
    private SubwayResponse mockResponse;

    @Mock
    private CardSubwayTime cardSubwayTime;

    @Mock
    private Result mockResult;




    @DisplayName("지하철 호선과 날짜를 입력하면 시간 별 승하차 정보를 준다.")
    @Test
    void getSeoulSubway() {

        given(client.getBoardingAlightingInfo(any())).willReturn(mockResponse);

        given(mockResponse.getCardSubwayTime()).willReturn(cardSubwayTime);
        given(cardSubwayTime.getListTotalCount()).willReturn(1);

        given(cardSubwayTime.getResult()).willReturn(mockResult);
        given(mockResult.getCode()).willReturn("INFO-000");
        given(mockResult.getMessage()).willReturn("정상 처리되었습니다");

        SubwayResponse response = client.getBoardingAlightingInfo(any());

        assertEquals(1, response.getCardSubwayTime().getListTotalCount());
        assertEquals("INFO-000", response.getCardSubwayTime().getResult().getCode());
        assertEquals("정상 처리되었습니다", response.getCardSubwayTime().getResult().getMessage());
    }

}