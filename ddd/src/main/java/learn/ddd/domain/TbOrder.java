package learn.ddd.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    private TbOrder(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public static TbOrder create(OrderStatus orderStatus) {
        return new TbOrder(orderStatus);
    }

    public boolean canChangeOrderState(StaffRole staffRole,OrderStatus currentState, OrderStatus newState) {
        if (StaffRole.BARISTA == staffRole) {
            return currentState == OrderStatus.PENDING && newState == OrderStatus.PROGRESS;
        }
        if (StaffRole.CASHIER == staffRole) {
            return currentState == OrderStatus.PROGRESS && newState == OrderStatus.READY;
        }
        return false;
    }

    public void changeInProgress(){
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
}
