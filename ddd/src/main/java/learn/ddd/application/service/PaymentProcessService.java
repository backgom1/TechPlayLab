package learn.ddd.application.service;

import learn.ddd.domain.TbOrder;
import learn.ddd.domain.TbPayment;
import learn.ddd.dto.request.payment.CreateUnpaidServiceRequest;
import learn.ddd.dto.request.payment.ProcessPaidServiceRequest;
import learn.ddd.dto.response.PaidPaymentResponse;
import learn.ddd.dto.response.UnpaidPaymentResponse;
import learn.ddd.infra.repository.OrderJpaRepository;
import learn.ddd.infra.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentProcessService {

    private final OrderJpaRepository orderJpaRepository;
    private final PaymentJpaRepository paymentJpaRepository;

    @Transactional
    public UnpaidPaymentResponse unpaidCreatePayment(CreateUnpaidServiceRequest serviceRequest) {

        TbOrder order = orderJpaRepository.findById(serviceRequest.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 주문입니다"));
        TbPayment tbPayment = new TbPayment(order, serviceRequest.getPaymentMethod());
        paymentJpaRepository.save(tbPayment);

        return UnpaidPaymentResponse.unpaid(order.getId(), tbPayment.getPaymentId());
    }

    @Transactional
    public PaidPaymentResponse processPayment(ProcessPaidServiceRequest serviceRequest) {

        TbOrder order = orderJpaRepository.findById(serviceRequest.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 주문입니다"));
        TbPayment payment = paymentJpaRepository.findById(serviceRequest.getPaymentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 결제입니다."));

        //+할지 말지 체크 유효성 검사

        order.changeInProgress();
        payment.completePay();

        return new PaidPaymentResponse("결제가 완료되었습니다.");
    }


}
