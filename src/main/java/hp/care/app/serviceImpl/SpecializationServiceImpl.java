package hp.care.app.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import hp.care.app.entity.Specialization;
import hp.care.app.exception.SpecializationNotFoundException;
import hp.care.app.repo.SpecializationRepository;
import hp.care.app.service.ISpecializationService;
import hp.care.app.util.MyCollectionsUtil;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

		@Autowired
		private SpecializationRepository repo;

		@Override
		public Long saveSpecialization(Specialization spec) {
			return repo.save(spec).getId();
		}

		@Override
		public List<Specialization> getAllSpecializations() {
			return repo.findAll();
			
		}

		@Override
		public void removeSpecialization(Long id) {	
			 repo.deleteById(id);
		}

		@Override
		public Specialization getOneSpecialization(Long id) {
//			Optional<Specialization>optional=repo.findById(id);
//				if(optional.isPresent()) {
//					return optional.get();
//				}else {
//					throw new SpecializationNotFoundException(id+ "not found"); 
//				}
			
			return repo.findById(id).orElseThrow(()->new SpecializationNotFoundException(id+ "not found")
					); 
		}

		@Override
		public void updateSpecialization(Specialization spec) {
		
			repo.save(spec);
			
		}

		@Override
		public boolean isSpecCodeExist(String specCode) {
		
		return repo.getSpecCodeCount(specCode)>0;
		}

		@Override
		public boolean isSpecCodeExistForEdit(String specCode, Long id) {
			return repo.getSpecCodeForEdit(specCode,id)>0;
			
		}

		@Override
		public Map<Long, String> getSpecIdAndName() {
			List<Object[]> list = repo.getSpecIdAndName();
			Map<Long,String> map = MyCollectionsUtil.convertToMap(list);
			return map;
		}

//		@Override
//		public Map<Long, String> getSpecIdAndName() {
//			List<Object[]> list= repo.getSpecIdAndName();
//			Map<Long,String> map= MyCollectionsUtil.convertListToMap(list);
//			return map;
//		}
//
//		

	

		
	
	

}
