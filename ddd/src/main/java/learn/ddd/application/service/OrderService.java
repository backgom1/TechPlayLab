package learn.ddd.application.service;

import learn.ddd.domain.*;
import learn.ddd.dto.request.order.CreateOrderServiceRequest;
import learn.ddd.exception.OrderException;
import learn.ddd.infra.repository.DrinkJpaRepository;
import learn.ddd.infra.repository.OrderDrinkJpaRepository;
import learn.ddd.infra.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final DrinkJpaRepository drinkJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final OrderDrinkJpaRepository orderDrinkJpaRepository;

    @Transactional(rollbackFor = OrderException.class)
    public void createOrder(List<CreateOrderServiceRequest> request) {

        TbOrder tbOrder = TbOrder.create(OrderStatus.PENDING);
        TbOrder order = orderJpaRepository.save(tbOrder);

        log.info("create order : {}", order);

        for (CreateOrderServiceRequest createRequest : request) {
            TbDrink drink = drinkJpaRepository.findById(createRequest.getDrinkId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 음료입니다."));

            drink.isCheckEmptyAmount();

            TbOrderDrink orderDrink = TbOrderDrink.create(order, drink, createRequest.getQuantity());

            List<TbDrinkAddOn> drinkAddOns = createRequest.getDrinkAddOn().stream()
                    .map(addon -> new TbDrinkAddOn(addon.getDrinkDetailComment(), addon.findSize(addon.getSize()), addon.getPrice()))
                    .collect(Collectors.toList());

            orderDrink.addOnDrink(drinkAddOns);

            orderDrinkJpaRepository.save(orderDrink);

        }

        log.info("create complete order : {}", order);
    }
}
