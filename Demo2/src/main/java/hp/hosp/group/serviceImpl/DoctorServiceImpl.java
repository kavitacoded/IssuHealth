package hp.hosp.group.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.hosp.group.Doctor;
import hp.hosp.group.repo.DoctorRepo;
import hp.hosp.group.service.IDoctorService;
@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepo doctorrepo;

	@Override
	public void deleteDoctor(Integer id) {

		doctorrepo.deleteById(id);
		
	}

	@Override
	public Integer saveDoctor(Doctor doctor) {
		doctor=doctorrepo.save(doctor);
		return doctor.getId();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> l=doctorrepo.findAll();
		return l;
	}

	@Override
	public Doctor getOneDoctor(Integer id) {
		Optional<Doctor> opt = doctorrepo.findById(id);
		if(opt.isPresent()) {
		Doctor d = opt.get();
			return d;
		}
		// TODO : else throw exception Employee not found
		return null;
	
		}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorrepo.save(doctor);
		
	}
}
