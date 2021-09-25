package hp.care.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hp.care.app.entity.Specialization;

@Repository
public interface Specializationrepository extends JpaRepository<Specialization,Integer>{

}
