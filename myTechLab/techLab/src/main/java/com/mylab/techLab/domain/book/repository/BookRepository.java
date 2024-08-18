package com.mylab.techLab.domain.book.repository;

import com.mylab.techLab.domain.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Long, Book> {

    boolean existsByIsbn(String isbn);


}
