package hp.care.app.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.care.app.constants.UsersRoles;
import hp.care.app.entity.Doctor;
import hp.care.app.entity.User;
import hp.care.app.exception.DoctorNotFoundException;
import hp.care.app.repo.DoctorRepository;
import hp.care.app.service.IDoctorService;
import hp.care.app.service.IUserService;
import hp.care.app.util.MyCollectionsUtil;
import hp.care.app.util.UserUtil;
@Service 
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;

	@Autowired
	private IUserService userService;
	@Autowired
	private UserUtil util;
	
	@Override
	public Long SaveDoctor(Doctor doc) {
		
		Long id = repo.save(doc).getId();
		if(id==null) {
			User user=new User();
			user.setDispalyName(doc.getFirstName()+ " " +doc.getLastName());
			user.setUsername(doc.getEmail());
			user.setPassword(util.genPwd());
			user.setRole(UsersRoles.Doctor.name());
			userService.saveUser(user);
			//TODO:Email part is pending
		}
		return id;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		
		return repo.findAll();
	}

	@Override
	public void RemoveDoctor(Long id) {
		repo.delete(getOneDoctor(id));
		
	}

	@Override
	public Doctor getOneDoctor(Long id) {
		
		return repo.findById(id).orElseThrow(
				()-> new DoctorNotFoundException(id+", not Exist")
				);

	}

	@Override
	public void updateDoctor(Doctor doc) {
		if(repo.existsById(doc.getId()))
		repo.save(doc);
		else {
			throw new DoctorNotFoundException(doc.getId()+", not exist");
		}
		
	}

	@Override
	public Map<Long, String> getDoctorAndNames() {
		List<Object[]> list =repo.getDoctorAndNames();
		return MyCollectionsUtil.convertToMapIndex(list);
		
	}
	
		
}