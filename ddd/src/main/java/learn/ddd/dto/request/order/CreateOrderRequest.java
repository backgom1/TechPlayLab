package learn.ddd.dto.request.order;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateOrderRequest {

    @NotBlank(message = "존재하지 않은 음료 id입니다.")
    private Long drinkId;

    private List<AddOnDrinkDto> drinkAddOn;

    private int quantity;
}
