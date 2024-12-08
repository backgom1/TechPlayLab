package learn.ddd.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbDrinkAddOn extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_add_on_id")
    private Long id;

    @Column(name = "drink_detail_comment")
    private String drinkDetailComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_drink_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TbOrderDrink orderDrink;

    @Enumerated(EnumType.STRING)
    private DrinkSize drinkSize;

    private int price;

    public TbDrinkAddOn(String drinkDetailComment, DrinkSize drinkSize, int price) {
        this.drinkDetailComment = drinkDetailComment;
        this.drinkSize = drinkSize;
        this.price = price;
    }
}
