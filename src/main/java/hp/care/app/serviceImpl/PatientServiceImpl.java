package hp.care.app.serviceImpl;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hp.care.app.constants.UsersRoles;
import hp.care.app.entity.Patient;
import hp.care.app.entity.User;
import hp.care.app.repo.PatientRepository;
import hp.care.app.service.IPatientService;
import hp.care.app.service.IUserService;
import hp.care.app.util.MyMailUtil;
import hp.care.app.util.UserUtil;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private IUserService userService; 
	
	@Autowired
	private UserUtil util;
	@Autowired
	private MyMailUtil mailUtil;
	
	
	@Override
	@Transactional
	public Long SavePatient(Patient patient) {
		Long id=repo.save(patient).getId();
		if(id!=null) {
			String pwd=util.genPwd();
			User user=new User();
			user.setDispalyName(patient.getFirstName()+" " +patient.getLastName());
			user.setUsername(patient.getEmail());
			user.setPassword(util.genPwd());
			user.setRole(UsersRoles.Patient.name());
			Long genId=userService.saveUser(user);
			if(genId!=null)
				new Thread(new  Runnable() {
					public void run() {
					 String text="User name is"+patient.getEmail() +",password is "+pwd;
					 mailUtil.send(patient.getEmail(), "Patient Addedd", text);
					}
				}).start();
			
		}
		return id;
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public List<Patient> getAllPatient() {
	
		return repo.findAll();
	}

	@Override
	@Transactional
	public void DeletePatient(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Patient getOnePatient(Long id) {
	
		return repo.findById(id).get();
	}

	@Override
	@Transactional
	public void updatePatient(Patient patient) {
		repo.save(patient);
		
	}

}
