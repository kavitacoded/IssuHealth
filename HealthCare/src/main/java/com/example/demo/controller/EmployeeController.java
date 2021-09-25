package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private IEmployeeService service; //HAS-A 
	
	
	@GetMapping("/register")
	public String showRegister() {
		return "EmpRegister";
	}
	
	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute Employee employee,
			Model model)
			{
			Integer id = service.saveEmployee(employee);
			String message = "Employee '"+id+"' Created";
			model.addAttribute("message", message);
			return "EmployeeRegister";
			}
	
	
}
