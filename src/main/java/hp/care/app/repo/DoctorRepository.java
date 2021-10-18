package hp.care.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hp.care.app.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

		@Query("SELECT id,firstName,lastName FROM Doctor")
		public List<Object[]>getDoctorAndNames();
}
