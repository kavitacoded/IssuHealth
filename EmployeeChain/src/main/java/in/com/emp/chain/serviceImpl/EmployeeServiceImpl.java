package in.com.emp.chain.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.com.emp.chain.entity.Employee;
import in.com.emp.chain.repo.EmployeeRepository;
import in.com.emp.chain.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository repo; //Has-A

	@Override
	public Integer saveEmployee(Employee employee) {
	
		employee=repo.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee>list=repo.findAll();
		return list;
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		
		 Optional<Employee>opt=repo.findById(id);
		 if(opt.isPresent()) {
			 Employee e=opt.get();
			 return e;
		 }
		 //TODO:else throw Exception Employee not found
			return null;
	}

	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);
		
	}

	
	

}
