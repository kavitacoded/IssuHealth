package in.com.emp.chain.service;

import java.util.List;



import in.com.emp.chain.entity.Employee;

public interface IEmployeeService {
	
	  Integer saveEmployee(Employee employee);
	  List<Employee>getAllEmployees();
	  void deleteEmployee(Integer id);
	  Employee getOneEmployee(Integer id);
	  void updateEmployee(Employee e);
	
}
