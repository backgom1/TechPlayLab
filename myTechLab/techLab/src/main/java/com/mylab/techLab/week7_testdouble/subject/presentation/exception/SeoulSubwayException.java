package com.mylab.techLab.week7_testdouble.subject.presentation.exception;

import com.mylab.techLab.week7_testdouble.subject.dto.response.SeoulSubwayResultDto;
import lombok.Getter;

@Getter
public class SeoulSubwayException extends RuntimeException {

    private final SeoulSubwayResultDto result;

    public SeoulSubwayException(SeoulSubwayResultDto result) {
        super(result.getResult().getMessage());
        this.result = result;
    }
}
