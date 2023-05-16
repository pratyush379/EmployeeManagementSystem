package com.pratyush.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
		//creating model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
	    return "new_employee";

	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.SaveEmployee(employee);
	    return "redirect:/";

	}
	
	@GetMapping("/updateEmployeeForm/{id}")
	public String updateEmployeeForm(@PathVariable( value = "id") long id , Model model) {
		//get Employee from service
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employee",employee);
	    return "update_employee";
	    

	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeForm(@PathVariable( value = "id") long id ) {
		this.employeeService.deleteEmployeeById(id);
	    return "redirect:/";
	    

	}
	
}
