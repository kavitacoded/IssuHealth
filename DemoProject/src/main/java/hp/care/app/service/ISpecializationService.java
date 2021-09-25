package hp.care.app.service;

import java.util.List;

import hp.care.app.entity.Specialization;

public interface ISpecializationService {

	//save delete edit
	
	Integer saveSpecialization(Specialization specialization);
	List<Specialization>getAllSpecialization();
	
	void deletespecialization(Integer id);
	Specialization getOneSpecialization(Integer id);
	void updateSpecialization(Specialization sp);
//	
//	Integer saveEmployee(Employee employee);
//	List<Employee> getAllEmployees();
//	void deleteEmployee(Integer id);
//	Employee getOneEmployee(Integer id);
//	void updateEmployee(Employee e);
	
	
//	
}
