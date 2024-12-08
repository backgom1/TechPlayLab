package learn.ddd.dto.request.order;

import learn.ddd.domain.DrinkSize;
import lombok.Getter;

@Getter
public class AddOnDrinkDto {
    private String drinkDetailComment;
    private String size;
    private int price;

    public DrinkSize findSize(String size) {
        if ("SMALL".equalsIgnoreCase(size)) {
            return DrinkSize.SMALL;
        }
        if ("MEDIUM".equalsIgnoreCase(size)) {
            return DrinkSize.MEDIUM;
        }
        return DrinkSize.LARGE;
    }
}
