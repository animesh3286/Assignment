package com.cov.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Department;
import com.cov.beans.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByDepartmentID(Department department, Integer integer);
	
	
//	
//	Employee getEmployeeById(int id);
//	Employee insert(Employee employee);
//	void UpdateEmployee(int id, Employee employee);
//	void deleteEmployee(int empid);
	

 	


}
