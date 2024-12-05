package learn.ddd.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbOrderDrink extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_drink_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TbOrder tbOrder;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TbDrink tbDrink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_add_on_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TbDrinkAddOn tbDrinkAddOn;

    private int quantity;

}
