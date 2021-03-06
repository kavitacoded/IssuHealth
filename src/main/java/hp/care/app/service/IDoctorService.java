
package hp.care.app.service;

import java.util.List;
import java.util.Map;

import hp.care.app.entity.Doctor;

public interface IDoctorService {

	public Long SaveDoctor(Doctor doctor);
	public List<Doctor> getAllDoctor();
	public void RemoveDoctor(Long id);
	public Doctor getOneDoctor(Long id);
	public void updateDoctor(Doctor doc);
	public Map<Long, String>getDoctorAndNames();
	public List<Doctor> findDoctorBySpecName(Long specId);
}
