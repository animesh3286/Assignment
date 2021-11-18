package com.cov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "regEmp", method = RequestMethod.GET)
	public ModelAndView newEmployee() {
		ModelAndView modelAndView = new ModelAndView("regEmployee", "employee", new Employee());
		return modelAndView;
	}

	@RequestMapping(value = "regEmp", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) throws InvalidEmployeeIdException {
		ModelAndView modelAndView = new ModelAndView("savedEmployee");
		modelAndView.addObject("emp", employeeService.save(emp));
		return modelAndView;
	}

	@RequestMapping("getEmp")
	public ModelAndView findEmployee() {
		ModelAndView modelAndView = new ModelAndView("showEmployees", "emps", employeeService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "getemps", method = RequestMethod.GET)
	public ModelAndView findEmployeeAll() throws InvalidEmployeeIdException {
		ModelAndView modelAndView = new ModelAndView("showEmployees");
		List<Employee> emps = employeeService.findAll();
		modelAndView.addObject("emps", emps);
		return modelAndView;
	}
}
