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

    /*
        1. 주문 정보 저장(아직 결제 안함 PENDING)
        2. 결제 진행(성공유무에 따라 Status 변경)
        3. 스탭이 음료 준비 완료 신호 보냄 ( orderStatus변경)
        4. 손님이 음료를 가져감 (orderstatus변경)
     */

    private final OrderJpaRepository orderJpaRepository;
    private final DrinkJpaRepository drinkJpaRepository;
    private final OrderFactory orderFactory;


    @Transactional
    public void createOrderWithDrinks(List<CreateOrderServiceRequest> serviceRequests) {
        TbOrder order = orderFactory.createOrder();
        for (CreateOrderServiceRequest request : serviceRequests) {
            TbDrink drink = drinkJpaRepository.findById(request.getDrinkId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 음료입니다."));
            order.addDrink(drink, request.getQuantity(), request.getDrinkAddOn());
        }
        orderJpaRepository.save(order);
    }
}
