package hp.care.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hp.care.app.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
