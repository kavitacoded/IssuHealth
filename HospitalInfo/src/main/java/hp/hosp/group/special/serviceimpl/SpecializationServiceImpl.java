package hp.hosp.group.special.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.hosp.group.special.entity.Specialization;
import hp.hosp.group.special.repo.SpecilizationRepo;
import hp.hosp.group.special.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService{
	
	@Autowired
	private SpecilizationRepo repo;
	@Override
	public Integer savePerson(Specialization specilization) {
		repo.save(specilization);
		return specilization.getSid();
	}
	@Override
	public List<Specialization> getAllemployeess() {
		
		List<Specialization> list=repo.findAll();
			return null;
	}

}
