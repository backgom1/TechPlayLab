package com.mylab.techLab.old.domain.book.exception;


import lombok.Getter;

@Getter
public enum BookErrorEnum {

    DUPLICATE_BOOK("1", "중복된 책이 존재합니다.");

    private final String code;
    private final String message;

    BookErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
