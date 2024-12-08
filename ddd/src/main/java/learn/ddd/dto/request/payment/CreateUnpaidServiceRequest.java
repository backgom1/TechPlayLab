package learn.ddd.dto.request.payment;

import lombok.Getter;

@Getter
public class CreateUnpaidServiceRequest {

    private Long orderId;
    private String paymentMethod;

    private CreateUnpaidServiceRequest(Long orderId, String paymentMethod) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
    }

    public static CreateUnpaidServiceRequest toServiceRequest(CreateUnpaidRequest request) {
        return new CreateUnpaidServiceRequest(request.getOrderId(), request.getPaymentMethod());
    }
}
