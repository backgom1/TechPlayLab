package com.mylab.techLab.week7_testdouble.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Result {
    @JsonProperty("CODE")
    private String code;
    @JsonProperty("MESSAGE")
    private String message;
}
