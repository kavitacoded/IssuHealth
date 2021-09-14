package hp.care.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hp.care.app.entity.Specialization;
import hp.care.app.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;
	
	@GetMapping("/all")
	//1 dislay all Specializations 
	public String viewAll(Model model) {
		List<Specialization>list=service.getAllSpecializations();
		model.addAttribute("list",list);
		return "SpecializationData";
	}
}
