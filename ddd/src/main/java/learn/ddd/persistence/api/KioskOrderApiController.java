package learn.ddd.persistence.api;


import jakarta.validation.Valid;
import learn.ddd.application.service.OrderService;
import learn.ddd.dto.request.order.CreateOrderRequest;
import learn.ddd.dto.request.order.CreateOrderServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping
@RestController
@RequiredArgsConstructor
public class KioskOrderApiController {

    private final OrderService orderService;

    @PostMapping("/api/v1/create")
    public void createOrder(@RequestBody @Valid List<CreateOrderRequest> request) {
        orderService.createOrder(CreateOrderServiceRequest.toServiceRequest(request));
    }

}
