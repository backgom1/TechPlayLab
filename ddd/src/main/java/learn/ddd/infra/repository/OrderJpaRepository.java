package learn.ddd.infra.repository;

import learn.ddd.domain.TbOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<TbOrder, Long> {
}
