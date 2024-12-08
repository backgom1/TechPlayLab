package learn.ddd.persistence.api;

import jakarta.validation.Valid;
import learn.ddd.application.service.PaymentProcessService;
import learn.ddd.dto.request.payment.CreateUnpaidRequest;
import learn.ddd.dto.request.payment.CreateUnpaidServiceRequest;
import learn.ddd.dto.request.payment.ProcessPaidRequest;
import learn.ddd.dto.request.payment.ProcessPaidServiceRequest;
import learn.ddd.dto.response.PaidPaymentResponse;
import learn.ddd.dto.response.UnpaidPaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentApiController {

    private final PaymentProcessService paymentProcessService;


    @PostMapping("/api/v1/pay/unpaid")
    public ResponseEntity<UnpaidPaymentResponse> createUnpaid(@RequestBody @Valid CreateUnpaidRequest request) {
        return ResponseEntity.ok(paymentProcessService.unpaidCreatePayment(CreateUnpaidServiceRequest.toServiceRequest(request)));
    }

    @PostMapping("/api/v1/pay/paid")
    public ResponseEntity<PaidPaymentResponse> processPayment(@RequestBody @Valid ProcessPaidRequest request) {
        return ResponseEntity.ok(paymentProcessService.processPayment(ProcessPaidServiceRequest.toServiceRequest(request)));
    }

}
