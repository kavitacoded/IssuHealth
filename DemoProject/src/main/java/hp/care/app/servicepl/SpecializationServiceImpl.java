package hp.care.app.servicepl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.care.app.entity.Specialization;
import hp.care.app.repo.Specializationrepository;
import hp.care.app.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService{

	@Autowired
	private Specializationrepository srepo;

	@Override
	public Integer saveSpecialization(Specialization specialization) {
		specialization=srepo.save(specialization);
		return specialization.getId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		List<Specialization> specialization=srepo.findAll();
		return specialization;
	}

	@Override
	public void deletespecialization(Integer id) {
		srepo.deleteById(id);
		
	}

	@Override
	public Specialization getOneSpecialization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSpecialization(Specialization sp) {
		// TODO Auto-generated method stub
		
	}
}
