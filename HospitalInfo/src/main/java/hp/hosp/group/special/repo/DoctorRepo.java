package hp.hosp.group.special.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import hp.hosp.group.special.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>{

}
