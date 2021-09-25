package hp.hosp.group.service;

import java.util.List;

import hp.hosp.group.Doctor;

public interface IDoctorService {

	Integer saveDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor getOneDoctor(Integer id);
	void updateDoctor(Doctor doctor);
	void deleteDoctor(Integer id);
}
