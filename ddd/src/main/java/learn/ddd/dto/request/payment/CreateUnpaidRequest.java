package learn.ddd.dto.request.payment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateUnpaidRequest {

    @NotBlank(message = "OrderId가 존재하지 않습니다.")
    private Long orderId;

    @NotBlank(message = "OrderId가 존재하지 않습니다.")
    private String paymentMethod;

}
