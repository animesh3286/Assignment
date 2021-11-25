package com.cov.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Department;
import com.cov.beans.Employee;

import com.cov.repo.EmployeeRepo;

@TestInstance(Lifecycle.PER_CLASS)
class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;
	@Mock
	EmployeeRepo employeeRepo;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
		List<Employee> employees = new ArrayList<>();
		Department d1 = new Department(1, "Sales");
		Department d2 = new Department(2, "Integration");
		Department d3 = new Department(3, "Management");
		Department d4 = new Department(4, "BRM");
		employees.add(new Employee(1, "jai", d1));
		employees.add(new Employee(2, "veeru", d2));
		employees.add(new Employee(3, "hari", d3));
		employees.add(new Employee(4, "anuj", d4));
		when(employeeRepo.findAll()).thenReturn(employees);
		Employee employeeExisting = new Employee(2, "veeru", d2);
		when(employeeRepo.findById(2)).thenReturn(Optional.of(employeeExisting));
	}

	@Test
	void testFindAll() {

		List<Employee> empList = employeeService.findAll();
		assertNotNull(empList);
		assertEquals(4, empList.size());
	}

	@Test
	void testFindById() {
// Person personExisting = new Person(2, "sai", "sudha");
// when(personRepo.findById(2)).thenReturn(Optional.of(personExisting));
		Employee employee = employeeRepo.findById(2).get();
		assertNotNull(employee);
		assertSame(employee.getName(), "hari");

		assertEquals(employee.getId(), 2);
	}

	@Test
	void testInsert() {
		Department d = new Department(1, "Sales");
		Employee employee = new Employee(5, "hii", d);
		when(employeeRepo.save(employee)).thenReturn(employee);
		Employee e = employeeRepo.save(employee);
		assertNotNull(e);
		assertSame(e.getName(), "hii");
		assertEquals(e.getId(), 5);
	}

	@Test
	void testUpdate() {
		Department d4 = new Department(4, "c");
		Employee employee = new Employee(4, "anuj", d4);
		when((employeeRepo.findById(employee.getId()))).thenReturn(Optional.of(employee));
		when(employeeRepo.save(employee)).thenReturn(employee);
		Employee e = employeeRepo.save(employee);
		assertNotNull(e);
		assertSame(e.getName(), "anuj");
		assertEquals(e.getId(), 4);
	}
}