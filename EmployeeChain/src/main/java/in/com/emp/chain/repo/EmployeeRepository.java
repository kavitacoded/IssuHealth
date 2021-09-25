package in.com.emp.chain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import in.com.emp.chain.entity.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
