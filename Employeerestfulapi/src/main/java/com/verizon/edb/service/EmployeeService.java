package com.verizon.edb.service;

import java.util.List;

import com.verizon.edb.model.Employee;


public interface EmployeeService {

	Employee getEmployeeById(long empId);
	
	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	boolean deleteEmployee(long empId);
	
	boolean existsByDept(String dept);
	
	Employee findByDept(String dept);
	
	List<Employee> findAllByLastName(String lastName);
}
