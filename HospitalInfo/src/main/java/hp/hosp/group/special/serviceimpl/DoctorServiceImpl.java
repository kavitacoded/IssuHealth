package hp.hosp.group.special.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.hosp.group.special.entity.Doctor;
import hp.hosp.group.special.repo.DoctorRepo;
import hp.hosp.group.special.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private DoctorRepo repo;
	
	@Override
	public Integer saveDoctor(Doctor doctor) {
	doctor=repo.save(doctor);
		return doctor.getDid();
	}

}
