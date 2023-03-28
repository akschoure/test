package com.app.service;

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
	public Employee getEmployeeById(Integer empId) {
		return employeeRepository.findById(empId).orElseThrow();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public void deleteEmployee(Integer empId) {
			employeeRepository.deleteById(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeeByAnyField(Integer empId, String city) {
		return  employeeRepository.findByEmpIdAndCity(empId, city);
	}

}
