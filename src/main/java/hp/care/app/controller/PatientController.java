package hp.care.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hp.care.app.entity.Patient;
import hp.care.app.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private IPatientService service;
	
	@GetMapping("/register")
	public String registerPatient(Model  model ) {
		model.addAttribute("patient",new Patient());
		return "PatientRegister";
	}
	@PostMapping("/save")
	public String savePatient(@ModelAttribute Patient patient ,Model model) {
		Long id=service.SavePatient(patient);
	
		model.addAttribute("message","Patient created with Id "+ id);
		model.addAttribute("patient",new Patient());
		return "PatientRegister";
	}
	
	@GetMapping("/all")
	public String getAllPatients(Model model,
			@RequestParam (value="message",required=false) 
			String message
			) {
			List<Patient> list= service.getAllPatient();
			model.addAttribute("list",list);
			model.addAttribute("message",message);
		return "PatientData";
	}
	
	public String deletePatient() {
		return "";
	}
	
	
	
}
