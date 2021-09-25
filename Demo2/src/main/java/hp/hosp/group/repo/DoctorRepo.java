package hp.hosp.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hp.hosp.group.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

}
