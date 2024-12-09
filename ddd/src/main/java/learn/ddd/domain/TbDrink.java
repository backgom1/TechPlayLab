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

    private int amount;

    private TbDrink(String drinkName, int price, int amount) {
        this.drinkName = drinkName;
        this.price = price;
        this.amount = amount;
    }

    public static TbDrink create(CreateDrinkServiceRequest request) {
        return new TbDrink(request.drinkName(), request.price(),0);
    }

    public static TbDrink update(UpdateDrinkServiceRequest request) {
        return new TbDrink(request.getDrinkName(), request.getPrice(),request.getAmount());
    }

    public void isCheckEmptyAmount() {
        if(amount<0){
            throw new IllegalArgumentException("음료가 존재하지 않습니다. 입고를 기다려주세요");
        }
    }
}
