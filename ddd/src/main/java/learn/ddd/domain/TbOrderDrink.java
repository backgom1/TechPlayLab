package learn.ddd.domain;

import jakarta.persistence.*;
import learn.ddd.dto.request.order.AddOnDrinkDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private int quantity;

    @OneToMany(mappedBy = "orderDrink", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TbDrinkAddOn> addOns = new ArrayList<>();

    @Builder
    private TbOrderDrink(TbOrder tbOrder, TbDrink tbDrink, int quantity) {
        this.tbOrder = tbOrder;
        this.tbDrink = tbDrink;
        this.quantity = quantity;
    }

    public static TbOrderDrink create(TbOrder tbOrder, TbDrink tbDrink, int quantity) {
        return TbOrderDrink.builder()
                .tbOrder(tbOrder)
                .tbDrink(tbDrink)
                .quantity(quantity).build();
    }

    public void addOnDrink(List<TbDrinkAddOn> tbDrinkAddOn) {
        this.addOns.addAll(tbDrinkAddOn);
    }

    public void addOn(List<AddOnDrinkDto> addOns) {
        List<TbDrinkAddOn> drinkAddOns = addOns.stream()
                .map(addon -> new TbDrinkAddOn(addon.getDrinkDetailComment(), addon.findSize(addon.getSize()), addon.getPrice()))
                .collect(Collectors.toList());
        //수량 깎은 로직이 필요함
        this.addOns.addAll(drinkAddOns);
    }
}
