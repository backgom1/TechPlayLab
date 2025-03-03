package com.mylab.techLab.week7_testdouble.subject.presentation.exception;

import com.mylab.techLab.week7_testdouble.subject.dto.response.SeoulSubwayResultErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeoulSubwayExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SeoulSubwayException.class)
    public SeoulSubwayResultErrorResponse handleSeoulSubwayException(SeoulSubwayException e) {
        return new SeoulSubwayResultErrorResponse(e.getResult().getResult().getCode(),e.getResult().getResult().getMessage());
    }

}
