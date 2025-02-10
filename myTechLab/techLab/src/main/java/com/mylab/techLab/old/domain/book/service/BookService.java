package com.mylab.techLab.old.domain.book.service;


import com.mylab.techLab.old.domain.book.dto.request.BookRegisterRequest;
import com.mylab.techLab.old.domain.book.exception.BookErrorEnum;
import com.mylab.techLab.old.domain.book.exception.BookException;
import com.mylab.techLab.old.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {


    private final BookRepository bookRepository;

    public void register(BookRegisterRequest request) {

        boolean existBook = bookRepository.existsByIsbn(request.getIsbn());

        if (existBook) {
            log.info("Book with isbn {} already exists", request.getIsbn());
            throw new BookException(BookErrorEnum.DUPLICATE_BOOK);
        }

    }
}
