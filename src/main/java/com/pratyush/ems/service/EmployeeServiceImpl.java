package com.pratyush.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratyush.ems.model.Employee;
import com.pratyush.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void SaveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee emp = null;
		if(optional.isPresent()) {
			emp = optional.get();
			
		}
		else {
			throw new RuntimeException("No Employee with id :" + id);
			
		}
		return emp;
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

    
}
