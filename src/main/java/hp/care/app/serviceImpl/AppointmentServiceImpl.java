package hp.care.app.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.care.app.entity.Appointment;
import hp.care.app.repo.AppointmentRepository;
import hp.care.app.service.IAppointmentService;
@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository repo;

	@Override
	@Transactional
	public Long SaveAppointment(Appointment appointment) {
		
		return repo.save(appointment).getId();
	}

	@Override
	@Transactional
	public void updateAppointment(Appointment appointment) {
		repo.save(appointment);
		
	}

	@Override
	@Transactional
	public void deleteAppointment(Long id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(
		
			)
	public Appointment getOneAppointment(Long id) {
	
		return repo.findById(id).get();
	}

	@Override
	@Transactional()
	public List<Appointment> getAllAppointments() {
	
		return repo.findAll();
	}
}
