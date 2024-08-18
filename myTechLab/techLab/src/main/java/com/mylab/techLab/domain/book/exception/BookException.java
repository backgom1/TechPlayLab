package com.mylab.techLab.domain.book.exception;

public class BookException extends RuntimeException {

    private final BookErrorEnum errorEnum;

    public BookException(BookErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}
