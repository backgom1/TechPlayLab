package com.mylab.techLab.old.domain.book.dto.request;

import lombok.Getter;

@Getter
public class BookRegisterRequest {

    private String isbn;
    private String title;
    private String author;
    private String publisher;

}
