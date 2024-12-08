package learn.ddd.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateDrinkRequest {

    @NotBlank(message = "음료 명이 존재하지 않습니다.")
    private String drinkName;

    @NotBlank(message = "가격이 존재하지 않습니다.")
    private int price;


    public static CreateDrinkServiceRequest toServiceRequest(CreateDrinkRequest request) {
        return new CreateDrinkServiceRequest(request.getDrinkName(), request.getPrice());
    }
}
