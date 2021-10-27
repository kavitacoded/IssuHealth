package hp.care.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import hp.care.app.entity.Doctor;
import hp.care.app.exception.DoctorNotFoundException;
import hp.care.app.service.IDoctorService;
import hp.care.app.service.ISpecializationService;
import hp.care.app.util.MyMailUtil;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private MyMailUtil mailUtil;
	
	@Autowired
	private IDoctorService service;
	
	@Autowired
	private ISpecializationService specializationService;
	/**
	 * A Common method which send data to create dynamic Dropdown at Ui 
	 * in register and Edit
	 * call this method inside controller method where those returns register 
	 * and edit
	 */
//	private void dynamicCommonUi(Model model) {
//		Map<Long,String> specializations= specializationService.getSpecIdAndName();
//		model.addAttribute("specialization", specializations);
//	}
//	
	private void createDyanamicUi(Model model) {
		model.addAttribute("specializations", specializationService.getSpecIdAndName());
	}

	
	//1 show register page
	@GetMapping("/register")
	public String showReg(
			@RequestParam (value="message",required=false)String message,
			Model model
			) {
		model.addAttribute("message",message);
		createDyanamicUi(model);     //method call
		return "DoctorRegister";
	}
	
	//2 save a submit
	@PostMapping("/save")
	public String save(
			@ModelAttribute Doctor doctor,
			RedirectAttributes attributes) {
			Long id=service.SaveDoctor(doctor);
			String message ="Doctor ("+id+") is Created";
			attributes.addAttribute("message",message);
			
			if(id!=null) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
					
						mailUtil.send(
							doctor.getEmail(), 
							"SUCCESS",
								message, 
								new ClassPathResource("/static/myres/sample.pdf") );
					}
				}).start();
	
			}
			return "redirect:register";
	}
	
	//3 display data
	@GetMapping("/all")
	public String display(
			@RequestParam(value="message",required = false )String message,
			Model model) {
		List<Doctor>list=service.getAllDoctor();
		model.addAttribute("list",list);
		model.addAttribute("message",message);
		return "DoctorData";
	} 
	
	//4 delete by id
	@GetMapping("/delete")
	public String delete(
			@RequestParam("id")Long id,
			RedirectAttributes attributes
			) {
		String message=null;
		try {
			service.RemoveDoctor(id);
			message="Doctor not found";
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			}
			attributes.addAttribute("message",message);
		return "redirect:all";
	}
	//5 Fetch data 
	@GetMapping("/edit")
	public String edit(
			@RequestParam("id")Long id,
			Model model,
			RedirectAttributes attributes
			)
	{
		String page = null;
		try {
			Doctor doc = service.getOneDoctor(id);
			model.addAttribute("doctor", doc);
			createDyanamicUi(model);
			page = "DoctorEdit";
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page; 
	}
	
	
	//6 do update
	@PostMapping("/update")
	public String doUpdate(
			@ModelAttribute Doctor doctor,
			RedirectAttributes attributes) {
		service.updateDoctor(doctor);
		attributes.addAttribute("message",doctor.getId()+", updated !");
		return"redirect:all";
	}
	
	//7 email and mobile duplicate validation using ajax
	
	//8 excel export
}
