package com.cov.repo;

import org.springframework.data.repository.CrudRepository;

import com.cov.beans.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	Department findByDepartmentID(int DepartmentID);
	
	
	

	


}
