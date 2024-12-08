package learn.ddd.infra.repository;

import learn.ddd.domain.TbPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<TbPayment,Long> {
}
