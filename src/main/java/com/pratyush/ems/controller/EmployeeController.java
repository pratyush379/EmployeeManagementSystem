package com.pratyush.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pratyush.ems.model.Employee;
import com.pratyush.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	// display list of all employees
	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("listEmloyees",employeeService.getAllEmployees());
	    return "index";
	}
	
	
	@GetMapping("/addNewEmployee")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
	    return "new_employee";

	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Model mo del) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
	    return "new_employee";

	}
	
}
