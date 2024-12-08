package learn.ddd.dto.response;

import lombok.Getter;

@Getter
public class DrinksResponse {

    private Long drinkId;

    private String drinkName;

    private int price;

    public DrinksResponse(Long id,String drinkName, int price) {
        this.drinkId = id;
        this.drinkName = drinkName;
        this.price = price;
    }
}
