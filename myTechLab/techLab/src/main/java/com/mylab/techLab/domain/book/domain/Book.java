package com.mylab.techLab.domain.book.domain;

import com.mylab.techLab.domain.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    private String title;

    private String isbn;

    @Embedded
    private Publish publish;

    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "del_yn")
    private String delYn;

}
