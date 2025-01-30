package com.springboot.backend.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.springboot.backend.exception.ResourceNotFoundException;
import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;
import com.springboot.backend.service.EmployeeService;


@Service
public class EmployeeServiceImplement implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	
	@Override
	public Employee getEmployeeById(Long Id) {
		Optional <Employee> employee = employeeRepository.findById(Id) ;
		
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", Id);
		}
	}

	
	@Override
	public Employee updateEmployee(Employee employee, long Id) {
		Employee existingEmployee = employeeRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", Id));
		
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	
	@Override
	
	public void deleteEmployee(Long Id) {
		employeeRepository.findById(Id).orElseThrow(() ->
		   new ResourceNotFoundException("Employee", "Id", Id));
		
		employeeRepository.deleteById(Id);
	}
}
