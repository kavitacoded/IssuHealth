package hp.care.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hp.care.app.entity.Doctor;

@Repository
public interface Doctorrepository extends JpaRepository<Doctor,Integer> {

}
