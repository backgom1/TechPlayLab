package learn.ddd.persistence.api;

import jakarta.validation.Valid;
import learn.ddd.application.service.StaffProcessOrderService;
import learn.ddd.dto.request.staff.StaffOrderProcessRequest;
import learn.ddd.dto.response.StaffOrderProcessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StaffProcessOrderApiController {

    private final StaffProcessOrderService orderService;

    public ResponseEntity<StaffOrderProcessResponse> processReadyOrder(@RequestBody @Valid StaffOrderProcessRequest request) {
        return ResponseEntity.ok(orderService.processReadyOrder(request));
    }

    public ResponseEntity<StaffOrderProcessResponse> pickupOrder(@RequestBody @Valid StaffOrderProcessRequest request) {
        return ResponseEntity.ok(orderService.pickUpOrder(request));
    }

}
