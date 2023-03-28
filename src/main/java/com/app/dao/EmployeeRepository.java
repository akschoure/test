package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Query("SELECT c FROM Employee c WHERE (:empId is null or c.empId = :empId) and (:city is null"
			  + " or c.city = :city)")
	List<Employee> findByEmpIdAndCity(Integer empId, String city);

}
