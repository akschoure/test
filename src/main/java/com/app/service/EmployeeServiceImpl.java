package com.app.service;

import com.app.service.exception.EmployeeAlreadyExistsException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dao.EmployeeRepository;
import com.app.pojos.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	

	@Override
	public Employee getEmployeeById(String empId) {
		return employeeRepository.findById(empId).orElseThrow();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if (employeeRepository.existsById(employee.getEmpId()))
			throw new EmployeeAlreadyExistsException("Employee Already Exists");
		return employeeRepository.save(employee);
	}


	@Override
	public void deleteEmployee(String empId) {
			employeeRepository.deleteById(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeeByAnyField(String empId, String city) {
		return  employeeRepository.findByEmpIdAndCity(empId, city);
	}

}
