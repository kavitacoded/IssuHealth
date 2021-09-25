package hp.hosp.group.special.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hp.hosp.group.special.entity.Specialization;

@Repository
public interface SpecilizationRepo extends JpaRepository<Specialization, Integer> {

}
