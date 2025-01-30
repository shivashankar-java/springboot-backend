package com.springboot.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Employee;
import com.springboot.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// Build create Emlpoyee REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee )  {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee) , HttpStatus.CREATED);
		
	}  
	
	// Build Get all Emlpoyee REST API	
	@GetMapping
	public List<Employee> getAllemployees(){
		return employeeService.getAllEmployee();
		
	}
	
	
	// Build Get  EmlpoyeeByID REST API
	//http://localhost:8080/api/employees/1
	@GetMapping("{Id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Long EmployeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(EmployeeId), HttpStatus.OK);
		
	}	
	
	// Build update Emlpoyee REST API
    //http://localhost:8080/api/employees/1
	
	@PutMapping("{Id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("Id")Long Id, @RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.updateEmployee(employee, Id), HttpStatus.OK);
		
	}
	
	// Build delete Employee REST API
	
	@DeleteMapping("{Id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("Id") Long Id){		
		
		employeeService.deleteEmployee(Id);
		return new ResponseEntity<String>("Employee deleted successfully..", HttpStatus.OK);
	}
	
}
