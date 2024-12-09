package learn.ddd.dto.request.order;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CreateOrderServiceRequest {

    private Long drinkId;

    private List<AddOnDrinkDto> drinkAddOn;

    private int quantity;

    public CreateOrderServiceRequest(Long drinkId, List<AddOnDrinkDto> drinkAddOn, int quantity) {
        this.drinkId = drinkId;
        this.drinkAddOn = drinkAddOn;
        this.quantity = quantity;
    }

    public static List<CreateOrderServiceRequest> toServiceRequest(List<CreateOrderRequest> requests) {
        if (requests == null || requests.isEmpty()) {
            return Collections.emptyList();
        }

        return requests.stream()
                .map(request -> new CreateOrderServiceRequest(request.getDrinkId(), request.getDrinkAddOn(),request.getQuantity()))
                .collect(Collectors.toList());
    }
}
