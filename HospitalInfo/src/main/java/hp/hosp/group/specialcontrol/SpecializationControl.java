package hp.hosp.group.specialcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hp.hosp.group.special.entity.Specialization;
import hp.hosp.group.special.service.ISpecializationService;

@Controller
@RequestMapping("/doctor")
public class SpecializationControl {
	
	@Autowired		//Has-A
	private ISpecializationService service;
	
	//if the end user enters register in address bar
	//this method is called and loads
	//employee register page from template folder
	
	@GetMapping("/register")
	public String showRegister()
	{		
		return "doctoregister";
	}
	
	//on form submit (Save+POST),read data as object using @ModelAttribute
	//call service layer with object ,read ID back
	//create message as string
	//use model memory, send message to ui
	//return back to dockerregister.html
	
	@PostMapping("/save")
	public String saveDoctor(
			@ModelAttribute Specialization specialization,
			Model model) {
		Integer id=service.savePerson(specialization);
		String message ="Doctor '"+id+"' Created";
		model.addAttribute("message", message);
		return "doctoregister";
		
	}
	
	
	
}
