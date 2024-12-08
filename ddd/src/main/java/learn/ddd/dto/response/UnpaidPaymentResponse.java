package learn.ddd.dto.response;

import lombok.Getter;

@Getter
public class UnpaidPaymentResponse {

    private Long orderId;
    private Long paymentId;
    private String message;

    private UnpaidPaymentResponse(Long orderId, Long paymentId, String message) {
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.message = message;
    }

    public static UnpaidPaymentResponse unpaid(Long orderId, Long paymentId) {
        return new UnpaidPaymentResponse(orderId, paymentId,"결제 기본 등록이 완료되었습니다.");
    }
}
