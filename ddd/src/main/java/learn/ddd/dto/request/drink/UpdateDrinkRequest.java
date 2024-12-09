package learn.ddd.dto.request.drink;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateDrinkRequest {

    @NotBlank(message = "음료 명이 존재하지 않습니다.")
    private String drinkName;

    @NotBlank(message = "가격이 존재하지 않습니다.")
    private int price;

    private int amount;



    public static UpdateDrinkServiceRequest toServiceRequest(UpdateDrinkRequest request) {
        return new UpdateDrinkServiceRequest(request.getDrinkName(), request.getPrice(),request.getAmount());
    }
}
