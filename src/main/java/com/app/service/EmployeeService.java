package com.app.service;

import java.util.List;
import com.app.pojos.*;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(String empId);
	
	Employee addEmployee(Employee employee);
	
	void deleteEmployee(String empId);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeeByAnyField(String empId, String city);
	
	
	

}
