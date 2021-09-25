package in.com.emp.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.com.emp.group.serviceImpl.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;
}
