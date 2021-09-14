package hp.care.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import hp.care.app.entity.Specialization;
import hp.care.app.repo.SpecializationRepository;
import hp.care.app.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

		@Autowired
		private SpecializationRepository repo;

		@Override
		public Long saveSpecialization(Specialization spec) {
			// TODO Auto-generated method stub
			return repo.save(spec).getId();
		}

		@Override
		public List<Specialization> getAllSpecializations() {
			// TODO Auto-generated method stub
			return repo.findAll();
			//return null;
		}

		@Override
		public void RemoveSpecialization(Long id) {
			// TODO Auto-generated method stub
			 repo.deleteById(id);
		}

		@Override
		public Specialization getOneSpecialization(Long id) {
			Optional<Specialization>optional=repo.findById(id);
				if(optional.isPresent()) {
					return optional.get();
				}else {
					return null;
				}
			
		}

		@Override
		public void updateSpecialization(Specialization spec) {
			// TODO Auto-generated method stub
			repo.save(spec);
			
		}
	
	

}