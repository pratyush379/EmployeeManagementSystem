package com.pratyush.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratyush.ems.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

}
