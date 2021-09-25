package in.com.emp.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.emp.group.entity.EmployeeG;

@Repository
public interface EmpRepo extends JpaRepository<EmployeeG, Integer> {

}
