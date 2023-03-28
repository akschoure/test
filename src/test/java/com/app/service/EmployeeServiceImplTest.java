package com.app.service;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.dao.EmployeeRepository;
import com.app.pojos.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

  EmployeeService employeeService;

  @Mock
  EmployeeRepository employeeRepository;

  @BeforeEach
  void setUp() {
    employeeService = new EmployeeServiceImpl(employeeRepository);
  }

  @Test
  void testGetAllEmployee() {
    Employee employee = new Employee();
    when(employeeRepository.findAll()).thenReturn(asList(employee));

    List<Employee> result = employeeService.getAllEmployee();

    assertEquals(asList(employee), result);
  }

  @Test
  void getEmployeeById() {
    Employee employee = new Employee();
    when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

    var result = employeeService.getEmployeeById(1);

    assertEquals(result, employee);
    verify(employeeRepository).findById(1);
  }

  @Test
  void addEmployee() {
    Employee employee = new Employee();
    when(employeeRepository.save(employee)).thenReturn(employee);

    var result = employeeService.addEmployee(employee);

    assertEquals(result, employee);
    verify(employeeRepository).save(employee);
  }


  @Test
  void deleteEmployee() {
    employeeService.deleteEmployee(1);

    verify(employeeRepository).deleteById(1);
  }

  @Test
  void updateEmployee() {
    Employee employee = new Employee();
    when(employeeRepository.save(employee)).thenReturn(employee);

    var result = employeeService.updateEmployee(employee);

    assertEquals(result, employee);
    verify(employeeRepository).save(employee);
  }

  @Test
  void getEmployeeByAnyField() {
    Employee employee = new Employee();
    when(employeeRepository.findByEmpIdAndCity(1, "NGP")).thenReturn(asList(employee));

    List<Employee> result = employeeService.getEmployeeByAnyField(1, "NGP");

    assertEquals(asList(employee), result);
  }

}