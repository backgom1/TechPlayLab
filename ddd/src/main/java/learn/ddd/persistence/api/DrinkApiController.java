package learn.ddd.persistence.api;


import jakarta.validation.Valid;
import learn.ddd.application.service.DrinkService;
import learn.ddd.dto.request.drink.CreateDrinkRequest;
import learn.ddd.dto.request.drink.UpdateDrinkRequest;
import learn.ddd.dto.response.DrinksResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DrinkApiController {

    private final DrinkService drinkService;

    @PostMapping("/api/v1/create/drink")
    public void createDrink(@Valid @RequestBody CreateDrinkRequest request) {
        drinkService.createDrink(CreateDrinkRequest.toServiceRequest(request));
    }

    @GetMapping("/api/v1/drinks")
    public List<DrinksResponse> findAllDrinks() {
        return drinkService.findAllDrinks();
    }

    @PutMapping("/api/v1/update/drink")
    public void updateDrink(@Valid @RequestBody UpdateDrinkRequest request) {
        drinkService.updateDrink(UpdateDrinkRequest.toServiceRequest(request));
    }

    @DeleteMapping("/api/v1/delete/drink/{deleteId}")
    public void deleteDrink(@PathVariable Long deleteId) {
        drinkService.deleteDrink(deleteId);
    }

}
