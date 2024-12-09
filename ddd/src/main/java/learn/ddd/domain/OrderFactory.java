package learn.ddd.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFactory {

    public TbOrder createOrder() {
        return TbOrder.create(OrderStatus.PENDING);
    }
}
