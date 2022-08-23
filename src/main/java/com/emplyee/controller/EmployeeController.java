package com.emplyee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emplyee.exception.ResourceNotFoundException;
import com.emplyee.model.Employee;
import com.emplyee.service.EmployeeService;

@RestController
@RequestMapping("/Start")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService ;
	
	@GetMapping("/emp")
	public List<Employee> getAllEmployee()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/create")
	public Employee createEmployee( @Validated @RequestBody Employee  employee  )
	{
		return   employeeService.save(employee);
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable (value = "id") long id) throws ResourceNotFoundException
	{
		Employee emp= employeeService.findById(id).orElseThrow(  ()->new ResourceNotFoundException("Resource not found :: " +  id) );
		return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping("/emp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable (value = "id") long id ,@RequestBody Employee empdetail) throws ResourceNotFoundException
	{
		Employee emp= employeeService.findById(id).orElseThrow(  ()->new ResourceNotFoundException("Resource not found :: " +  id) );
		emp.setFistname(empdetail.getFistname());
		emp.setLastname(empdetail.getLastname());
		employeeService.save(emp);
		return ResponseEntity.ok().body(emp);
	}
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable (value = "id") long id ,@RequestBody Employee empdetail) throws ResourceNotFoundException
	{
		employeeService.findById(id).orElseThrow(  ()->new ResourceNotFoundException("Resource not found :: " +  id) );
		employeeService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
