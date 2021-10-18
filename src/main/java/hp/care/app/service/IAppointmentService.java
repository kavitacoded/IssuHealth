package hp.care.app.service;

import java.util.List;

import hp.care.app.entity.Appointment;

public interface IAppointmentService {

	public Long SaveAppointment(Appointment appointment);
	void updateAppointment(Appointment appointment);
	void deleteAppointment(Long id);
	Appointment getOneAppointment(Long id);
	public List<Appointment> getAllAppointments();
	
	
}
