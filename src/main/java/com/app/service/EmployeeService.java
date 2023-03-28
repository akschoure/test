package com.app.service;

import java.util.List;
import com.app.pojos.*;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Integer empId);
	
	Employee addEmployee(Employee employee);
	
	void deleteEmployee(Integer empId);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeeByAnyField(Integer empId, String city);
	
	
	

}
