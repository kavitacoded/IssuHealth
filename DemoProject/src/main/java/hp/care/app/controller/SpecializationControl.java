package hp.care.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hp.care.app.entity.Specialization;
import hp.care.app.service.ISpecializationService;

@Controller
@RequestMapping("/specialization")
public class SpecializationControl {

	@Autowired
	private ISpecializationService service; //Has-A
	
	@GetMapping("/register")
	public String register() {
		return "SpecializationRegister";
	}
	
	@PostMapping("/save")
	public String saveSpecialization(
			@ModelAttribute Specialization specialization,
			Model model
			)
	{
		System.out.println(model.getClass().getName());
		Integer id=service.saveSpecialization(specialization);
		String message="specialization '"+id+"' Created";
		model.addAttribute("message",message);
		return "SpecializationRegister";
		
	}
}
