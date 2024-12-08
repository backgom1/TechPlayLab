package learn.ddd.infra.repository;

import learn.ddd.domain.TbOrderDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDrinkJpaRepository extends JpaRepository<TbOrderDrink,Long> {
}
