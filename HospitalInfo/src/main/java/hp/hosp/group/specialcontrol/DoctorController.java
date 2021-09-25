package hp.hosp.group.specialcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hp.hosp.group.special.entity.Doctor;
import hp.hosp.group.special.serviceimpl.DoctorServiceImpl;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorServiceImpl service;  //Has-a

	@GetMapping("/register")
	public String Register() {
	return "DoctorRegister";
}

	
	
	@PostMapping("/save")
	public String saveDoctor(
		@ModelAttribute Doctor doctor
					,Model model
		) {
		
		Integer id=service.saveDoctor(doctor);
	String message="Doctor '"+id+"' created.";
		model.addAttribute("message", message);
		
		return "DoctorRegister";
		
	}
	
	
	
	
}
