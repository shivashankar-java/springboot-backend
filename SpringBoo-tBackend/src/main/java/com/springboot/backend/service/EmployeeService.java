package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long Id);
	
	Employee updateEmployee(Employee employee, long Id);
	
    void deleteEmployee(Long Id);
 }
