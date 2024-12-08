package learn.ddd.dto.request.payment;

import lombok.Getter;

@Getter
public class ProcessPaidServiceRequest {

    private Long orderId;
    private Long paymentId;

    private ProcessPaidServiceRequest(Long orderId, Long paymentId) {
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public static ProcessPaidServiceRequest toServiceRequest(ProcessPaidRequest request) {
        return new ProcessPaidServiceRequest(request.getOrderId(),request.getPaymentId());
    }
}
