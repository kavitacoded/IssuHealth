package in.com.emp.chain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.com.emp.chain.entity.Employee;
import in.com.emp.chain.serviceImpl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;  //Has-A
	
	@GetMapping("/register")
	private String showRegister() {
		return "EmployeeRegister";
	}
	

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee,
			Model model) {
		Integer id=service.saveEmployee(employee);
		String message="Employee '"+id+"' Created";
		model.addAttribute("message",message);
		return "EmployeeRegister";
		}
	
	@GetMapping("/all")
	public String viewAllEmployee(Model model) {
	 List<Employee>list=service.getAllEmployees();
	model.addAttribute("list", list);
	return "EmployeeData";}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(
			
			@RequestParam Integer id,
			Model model
			) {
		//call service
		service.deleteEmployee(id);
		
		//one succcess message
		String message="Employee ' "+ id +" ' Deleted";
		
		model.addAttribute("message",message);
		
		//get latest data
		 List<Employee>list=service.getAllEmployees();
			model.addAttribute("list", list);
		
		
		return "EmployeeData";
		
	}
	@GetMapping("/edit")
	public String showEmployeeEdit(
			@RequestParam Integer id,
			Model model
			) {
		//load obejct from DB
		Employee employee=service.getOneEmployee(id);
		//send object to UI
		model.addAttribute("employee",employee);
		//return to view page
		return "EmployeeEdit";
	}
	
	@PostMapping("update")
	public String updateEmployee(
			@ModelAttribute Employee employee) {
		service.updateEmployee(employee);
		return "redirect:all";
	}
	
}
