package hp.hosp.group.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hp.hosp.group.Doctor;
import hp.hosp.group.service.IDoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorControl {

	@Autowired
	 private IDoctorService service;
	
	@GetMapping("/register")
	public String showRegister() {
		return "DoctorRegister";
	}
	@GetMapping("/edit")
	public String showEmployeeEdit(
			@RequestParam Integer id,
			Model model
			) 
	{
		//load object from DB
		Doctor doctor = service.getOneDoctor(id);
		//send object to UI
		model.addAttribute("doctor", doctor);
		//return to View page
		return "DoctorEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(
			@ModelAttribute Doctor doctor,
			RedirectAttributes attributes
			) 
	{
		service.updateDoctor(doctor);
		attributes.addAttribute("message", "Employee '"+doctor.getId()+"' Updated");
		return "redirect:all";
	}
	
	@GetMapping("/delete")
	public String DeleteDoctor(
			@RequestParam Integer id,Model model) {
			//call service
			service.deleteDoctor(id);
			//one success message
			String message="Doctor '"+id+"'Created";
			//get latest data
			model.addAttribute("message", message);
			return"DoctorData";
	}
	
	@GetMapping("/all")
	public String viewAllEmployees(
			@RequestParam(required = false) String message,
			Model model
			)
	{
		List<Doctor> list = service.getAllDoctors();
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		return "EmployeeData";
	}
	
	
	
}
