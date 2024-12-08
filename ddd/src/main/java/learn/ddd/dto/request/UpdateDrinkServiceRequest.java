package learn.ddd.dto.request;

import lombok.Getter;

@Getter
public class UpdateDrinkServiceRequest {

    private final String drinkName;

    private final int price;


    public UpdateDrinkServiceRequest(String drinkName, int price) {
        this.drinkName = drinkName;
        this.price = price;
    }
}
