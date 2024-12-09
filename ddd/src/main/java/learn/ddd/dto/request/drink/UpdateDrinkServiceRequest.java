package learn.ddd.dto.request.drink;

import lombok.Getter;

@Getter
public class UpdateDrinkServiceRequest {

    private final String drinkName;

    private final int price;

    private final int amount;


    public UpdateDrinkServiceRequest(String drinkName, int price, int amount) {
        this.drinkName = drinkName;
        this.price = price;
        this.amount = amount;
    }
}
