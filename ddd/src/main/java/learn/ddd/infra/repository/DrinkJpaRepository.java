package learn.ddd.infra.repository;

import learn.ddd.domain.TbDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkJpaRepository extends JpaRepository<TbDrink,Long> {
}
