package learn.ddd.domain;

import jakarta.persistence.*;
import learn.ddd.dto.request.drink.CreateDrinkServiceRequest;
import learn.ddd.dto.request.drink.UpdateDrinkServiceRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TbDrink extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drink_id")
    private Long id;

    @Column(name = "drink_name")
    private String drinkName;

    private int price;


    private TbDrink(String drinkName, int price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    public static TbDrink create(CreateDrinkServiceRequest request) {
        return new TbDrink(request.drinkName(), request.price());
    }

    public static TbDrink update(UpdateDrinkServiceRequest request) {
        return new TbDrink(request.getDrinkName(), request.getPrice());
    }

}
