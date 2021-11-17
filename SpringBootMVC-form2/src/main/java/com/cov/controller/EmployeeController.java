package com.cov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.EmployeeService;

@Controller

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "regemp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelAndView = new ModelAndView("regEmployee", "employee", new Employee());
		return modelAndView;

	}

	@RequestMapping(value = "regemp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		ModelAndView modelAndView = new ModelAndView("savedEmployee");
		modelAndView.addObject("emp", employeeService.save(emp));
		return modelAndView;

	}

	@RequestMapping(value="getEmp")
	public ModelAndView findEmployee(Employee employee) {
		ModelAndView modelAndView = new ModelAndView("showEmployees", "emps", employeeService.findAll());
		return modelAndView;

	}
	@RequestMapping(value = "editEmp", method =RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws InvalidEmployeeIdException{
		Employee empToEdit = employeeService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editEmployees","empToEdit",empToEdit);
		return modelAndView;
	}
	@RequestMapping(value = "updateEmp",method = RequestMethod.POST)
	public ModelAndView updateEditEmp(@ModelAttribute("empToEdit") Employee employee) throws InvalidEmployeeIdException
	{
		employeeService.update(employee);
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getEmp");
		System.out.println("Employee updated successfully with id :"+employee.getId());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "deleteEmp")
	public ModelAndView deleteEmp(@RequestParam int id) throws InvalidEmployeeIdException
	{
		employeeService.delete(id);
		ModelAndView modelAndView = new ModelAndView("redirect :"+"getEmp");
		return modelAndView;
	}
	
	
	}