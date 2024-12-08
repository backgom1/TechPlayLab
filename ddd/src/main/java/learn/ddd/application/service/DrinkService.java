package learn.ddd.application.service;


import learn.ddd.domain.TbDrink;
import learn.ddd.dto.request.drink.CreateDrinkServiceRequest;
import learn.ddd.dto.request.drink.UpdateDrinkServiceRequest;
import learn.ddd.dto.response.DrinksResponse;
import learn.ddd.infra.repository.DrinkJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkJpaRepository drinkJpaRepository;

    @Transactional
    public void createDrink(CreateDrinkServiceRequest request) {
        TbDrink drink = TbDrink.create(request);
        drinkJpaRepository.save(drink);
    }


    @Transactional(readOnly = true)
    public List<DrinksResponse> findAllDrinks() {
        return drinkJpaRepository.findAll().stream()
                .map(drink -> new DrinksResponse(drink.getId(), drink.getDrinkName(), drink.getPrice()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateDrink(UpdateDrinkServiceRequest request) {
        TbDrink updatedDrink = TbDrink.update(request);
        drinkJpaRepository.save(updatedDrink);
    }

    @Transactional
    public void deleteDrink(Long id) {
        TbDrink drink = drinkJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 음료 id 입니다"));
        drinkJpaRepository.delete(drink);
    }

}
