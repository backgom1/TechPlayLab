package learn.ddd.application.service;

import learn.ddd.domain.TbDrink;
import learn.ddd.domain.TbOrder;
import learn.ddd.domain.TbOrderDrink;
import learn.ddd.dto.request.order.CreateOrderServiceRequest;
import learn.ddd.infra.repository.DrinkJpaRepository;
import learn.ddd.infra.repository.OrderDrinkJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDrinkService {

}
