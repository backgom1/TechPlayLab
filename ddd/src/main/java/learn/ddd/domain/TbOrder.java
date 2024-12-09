package learn.ddd.domain;

import jakarta.persistence.*;
import learn.ddd.dto.request.order.AddOnDrinkDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tbOrder")
    List<TbOrderDrink> tbOrderDrinks = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    private TbOrder(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public static TbOrder create(OrderStatus orderStatus) {
        return new TbOrder(orderStatus);
    }

    public boolean canChangeOrderState(StaffRole staffRole, OrderStatus currentState, OrderStatus newState) {
        if (StaffRole.BARISTA == staffRole) {
            return currentState == OrderStatus.PENDING && newState == OrderStatus.PROGRESS;
        }
        if (StaffRole.CASHIER == staffRole) {
            return currentState == OrderStatus.PROGRESS && newState == OrderStatus.READY;
        }
        return false;
    }

    public void changeInProgress() {
        //캐셔 권한도 추가 해야됌
        if (this.orderStatus != OrderStatus.PENDING) {
            throw new IllegalStateException("이미 주문이 들어간 음료입니다.");
        }
        this.orderStatus = OrderStatus.PROGRESS;
    }

    public void changeReady(StaffRole staffRole) {
        if (staffRole != StaffRole.BARISTA) {
            throw new IllegalArgumentException("바리스타 권한이 아닙니다.");
        }
        this.orderStatus = OrderStatus.READY;
    }

    public void changePickup() {
        this.orderStatus = OrderStatus.COMPLETED;
    }

    public void addDrink(TbDrink drink, int quantity, List<AddOnDrinkDto> addOns) {
        check(drink);
        TbOrderDrink orderDrink = TbOrderDrink.create(this, drink, quantity);
        orderDrink.addOn(addOns);
        this.tbOrderDrinks.add(orderDrink);
    }

    public void check(TbDrink drink) {
        if (drink.getAmount() < 0) {
            //예외
        }
    }
}
