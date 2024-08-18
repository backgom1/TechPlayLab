package com.mylab.techLab.domain.user.domain;

import com.mylab.techLab.domain.book.domain.Book;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ShoppingCart cart;
}
