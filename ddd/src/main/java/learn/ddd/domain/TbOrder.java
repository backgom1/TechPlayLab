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

    public void changeInProgress(){
        if (this.orderStatus != OrderStatus.PENDING) {
            throw new IllegalStateException("이미 주문이 들어간 음료입니다.");
        }
        this.orderStatus = OrderStatus.PROGRESS;
    }

}
