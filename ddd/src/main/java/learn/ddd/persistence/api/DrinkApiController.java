package learn.ddd.persistence.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DrinkApiController {



    @PostMapping("/api/v1/create/drink")
    public void createDrink() {

    }

}
