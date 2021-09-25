package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmplyeeRepo;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmplyeeRepo reo; //HAS-A

	@Override
	public List<Employee> getAllEmployees() {
		
		return null;
	}

	@Override
	public Integer saveEmployee(Employee employee) {
		
		return null;
	}
}
