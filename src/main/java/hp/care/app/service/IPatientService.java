package hp.care.app.service;

import java.util.List;

import hp.care.app.entity.Patient;

public interface IPatientService {

	public Long SavePatient(Patient patient);

	public List<Patient> getAllPatient();

	public void DeletePatient(Long id);

	public Patient getOnePatient(Long id);

	public void updatePatient(Patient patient);

}
