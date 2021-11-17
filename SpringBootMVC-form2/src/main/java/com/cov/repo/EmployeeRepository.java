package com.cov.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
