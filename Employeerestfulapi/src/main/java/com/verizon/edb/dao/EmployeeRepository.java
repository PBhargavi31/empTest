package com.verizon.edb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.edb.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	boolean existsByDept(String dept);
	
	Employee findByDept(String dept);
	
	List<Employee> findAllByLastName(String lastName);
	
}
