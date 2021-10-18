package hp.care.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hp.care.app.entity.Appointment;
import hp.care.app.exception.AppointmentNotFoundException;
import hp.care.app.service.IAppointmentService;
import hp.care.app.service.IDoctorService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService service;
	@Autowired
	private IDoctorService doctorserice;
	
	private void CommonUI(Model model) {
		model.addAttribute("doctors", doctorserice.getDoctorAndNames());
	}

	@GetMapping("/register")
	public String registerAppointment(Model model) {
		model.addAttribute("appointment", new Appointment());
		CommonUI(model);
		return "AppointmentRegister";
	}

	@PostMapping("/save")
	public String saveAppointment(@ModelAttribute Appointment appointment, Model model) {
			Long id=service.SaveAppointment(appointment);
			model.addAttribute("message","Appointment created with id :"+id );
			model.addAttribute("appointment",new Appointment());
			CommonUI(model);
			return "AppointmentRegister";
	}
	
	@GetMapping("/delete")
	public String deleteAppointment(@RequestParam Long id , RedirectAttributes attributes )
	{
		try {
			service.deleteAppointment(id);
			attributes.addAttribute("message","Appointment deleted with id :"+id);
		} catch (AppointmentNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}
	@GetMapping("/edit")
	public String editAppointment(@RequestParam Long id,Model model ,RedirectAttributes attributes) {
		String page=null;
		try {
			Appointment ob=service.getOneAppointment(id);
			model.addAttribute("appointment",ob);
			CommonUI(model);
			page="AppointmentEdit";
		} catch (AppointmentNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message",e.getMessage());
			page="redirect:all";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateAppointment(@ModelAttribute Appointment appointment,
			RedirectAttributes attributes) {
		service.updateAppointment(appointment);
		attributes.addAttribute("message","Appointment updated");
		return "redirect:all";
	}
}
