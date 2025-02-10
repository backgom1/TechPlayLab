package com.mylab.techLab.old.domain.book.controller;


import com.mylab.techLab.old.domain.book.dto.request.BookRegisterRequest;
import com.mylab.techLab.old.domain.book.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/book/register")
    public void registerBook(@Valid @RequestBody BookRegisterRequest request){
        bookService.register(request);
    }

}
