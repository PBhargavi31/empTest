package com.verizon.edb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.edb.dao.EmployeeRepository;
import com.verizon.edb.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee getEmployeeById(long empId) {
Employee emp=null;
		
		
		
		Optional<Employee> optEmployee =empRepo.findById(empId);
		if(optEmployee.isPresent()) {
			emp = optEmployee.get();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public boolean deleteEmployee(long empId) {
		boolean isDeleted=false;
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			isDeleted=true;
		}
		return isDeleted;
	}
	
	
	@Override
	public boolean existsByDept(String dept) {
		return empRepo.existsByDept(dept);
	}

	@Override
	public Employee findByDept(String dept) {
		return empRepo.findByDept(dept);
	}

	@Override
	public List<Employee> findAllByLastName(String lastName) {
		return empRepo.findAllByLastName(lastName);
	}

}
