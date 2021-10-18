package hp.care.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hp.care.app.entity.Appointment;

@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment, Long>{

}
