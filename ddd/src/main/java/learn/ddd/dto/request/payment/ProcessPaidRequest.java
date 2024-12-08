package learn.ddd.dto.request.payment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ProcessPaidRequest {

    @NotBlank(message = "OrderId가 존재하지 않습니다.")
    private Long orderId;

    @NotBlank(message = "PaymentId가 존재하지 않습니다.")
    private Long paymentId;


}
