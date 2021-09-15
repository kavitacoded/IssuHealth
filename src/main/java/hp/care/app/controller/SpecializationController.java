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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hp.care.app.entity.Specialization;
import hp.care.app.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;
	
		//	1 register 
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
	}
	
	//2 on submit Form Save Data
	//read data from uI using model attribute and sent data back to uI using model
	@PostMapping("/save")
	public String saveForm(
			@ModelAttribute Specialization specialization,
			Model model
			) {
		Long id=service.saveSpecialization(specialization);
		String message="Record ("+id+") is created";
		model.addAttribute("message",message);
		return "SpecializationRegister";
	}
	
	
	@GetMapping("/all")
	//3 display all Specializations 
	public String viewAll(Model model,
			@RequestParam(value="message", required=false) String message
			) {
		List<Specialization>list=service.getAllSpecializations();
		model.addAttribute("list",list);
		model.addAttribute("message", message);
		//return "Data";
		return "SpecializationData";
	}
	
	//4 Delete by id
	@GetMapping("/delete") 
	public String deleteData(
			@RequestParam Long id,
			//passing one data to another user redirect attribute
			RedirectAttributes attributes
			) {
		service.removeSpecialization(id);
		
		attributes.addAttribute("message","Record ("+id+") is removed");
		return "redirect:all";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
