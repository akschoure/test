package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Employee;
import com.app.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/allemployee")
	public List<Employee> getAllEmployee(){
		return employeeServiceImpl.getAllEmployee();
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer empId){
		return ResponseEntity.ok(employeeServiceImpl.getEmployeeById(empId));
	}
	
	
	@PostMapping
	public ResponseEntity<?> addEmployee(@RequestBody Employee transientEmployee){
		return new ResponseEntity<>(employeeServiceImpl.addEmployee(transientEmployee),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId){
		employeeServiceImpl.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable Integer empId){
		employee.setEmpId(empId);
		employeeServiceImpl.getEmployeeById(empId);
		return ResponseEntity.ok(employeeServiceImpl.updateEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<?> getEmployee(@RequestParam (required=false) Integer empId , @RequestParam (required=false) String city){
		return ResponseEntity.ok(employeeServiceImpl.getEmployeeByAnyField(empId, city));
	}

}
