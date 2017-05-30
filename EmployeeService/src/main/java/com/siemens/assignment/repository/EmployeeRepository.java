package com.siemens.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siemens.assignment.entity.Address;
import com.siemens.assignment.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public Employee findByEmployeeId(Long id);
	public Employee findByCode(String code);
	public Employee findByEmployeeName(String name);
	public Employee findByEmployeeAddress(Address address);
}
