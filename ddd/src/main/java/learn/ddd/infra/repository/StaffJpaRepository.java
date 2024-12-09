package learn.ddd.infra.repository;

import learn.ddd.domain.TbStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffJpaRepository extends JpaRepository<TbStaff,Long> {
}
