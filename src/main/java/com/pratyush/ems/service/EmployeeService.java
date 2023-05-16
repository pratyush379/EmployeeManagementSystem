package com.pratyush.ems.service;

import java.util.List;

import com.pratyush.ems.model.Employee;

public interface EmployeeService {
List<Employee> getAllEmployees();
void SaveEmployee(Employee employee);
Employee getEmployeeById(long id);
void deleteEmployeeById(long id);
}
