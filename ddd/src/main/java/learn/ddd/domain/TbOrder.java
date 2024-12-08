package learn.ddd.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
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


}
