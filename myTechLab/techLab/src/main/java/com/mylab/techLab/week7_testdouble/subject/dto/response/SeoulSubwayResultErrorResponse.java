package com.mylab.techLab.week7_testdouble.subject.dto.response;

import lombok.Getter;

@Getter
public class SeoulSubwayResultErrorResponse {
    private String code;
    private String message;

    public SeoulSubwayResultErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
