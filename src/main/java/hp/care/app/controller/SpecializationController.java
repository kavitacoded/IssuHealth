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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hp.care.app.entity.Specialization;
import hp.care.app.exception.SpecializationNotFoundException;
import hp.care.app.service.ISpecializationService;
import hp.care.app.view.SpecializationExcelView;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;

	// 1 register
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
	}

	// 2 on submit Form Save Data
	// read data from uI using model attribute and sent data back to uI using model
	// or To read Form Data
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Specialization specialization, Model model) {
		Long id = service.saveSpecialization(specialization);
		String message = "Record (" + id + ") is created";
		model.addAttribute("message", message);
		return "SpecializationRegister";
	}

	@GetMapping("/all")
	// 3 display all Specializations
	public String viewAll(Model model,
			@RequestParam(value = "message", required = false) String message) {
		List<Specialization> list = service.getAllSpecializations();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		// return "Data";
		return "SpecializationData";
	}

	// 4 Delete by id
	@GetMapping("/delete")
	public String deleteData(
			@RequestParam Long id,
			RedirectAttributes attributes
			) 
	{
		try {
			service.removeSpecialization(id);
			attributes.addAttribute("message", "Record ("+id+") is removed");
		} catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}

	/**
	 * * 5. Fetch Data into Edit page by Id
	 */

	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id, Model model,
			RedirectAttributes attributes) {
		//before try catch block
//		Specialization spec = service.getOneSpecialization(id);
//		model.addAttribute("specialization", spec);
//		return "SpecializationEdit";
		
		//after try catch block
		String page=null;
		try {
			Specialization spec = service.getOneSpecialization(id);
			model.addAttribute("specialization", spec);
			page="SpecializationEdit";
		} catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page="redirect:all";
		}
		return page;	
	}
	/**
	 * 6
	 */
	@PostMapping("/update")
	public String updateData(

			@ModelAttribute Specialization specialization, RedirectAttributes attributes) {
		service.updateSpecialization(specialization);
		attributes.addAttribute("message", "Record (" + specialization.getId() + ") is updated");
		return "redirect:all";

	}
	/**
	 * 7 Read code and check with service
	 * Return message back to UI
	 */
	
	@GetMapping("/checkCode")
	public @ResponseBody() String validateSpecCode(
			@RequestParam String code,
			@RequestParam Long id) {
		
		String message = "";
		if(id==0 && service.isSpecCodeExist(code)) { //register check
			message="code+ ,already exists ";//this is response
		}else if(id!=0 && service.isSpecCodeExistForEdit(code,id)) { //edit check
		message="code+ ,already exists ";
		}
		//this is not view or html file its only response
		return message;
	}
	//8 excel view
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m=new ModelAndView();
		m.setView(new SpecializationExcelView());
		//read data from DB
		List<Specialization>list=service.getAllSpecializations();
		//send to Excel Impl class
		m.addObject("list",list);
		return m;
	}
	

	

}
