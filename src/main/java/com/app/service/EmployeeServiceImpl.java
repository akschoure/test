package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeRepository;
import com.app.pojos.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	public EmployeeRepository employeeRepository;
	

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
	public Employee readEmployee(Integer empId) {
		return employeeRepository.findById(empId).orElseThrow();
	}


	@Override
	public Integer deleteEmployee(Integer empId) {
			Employee existingEmpl = readEmployee(empId);
			employeeRepository.deleteById(existingEmpl.getEmpId());
		    return existingEmpl.getEmpId();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		//Employee existingEmployee = readEmployee(empId);
		
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeeByAnyField(Integer empId, String city) {
		return  employeeRepository.findByEmpIdAndCity(empId, city);
	}

}
