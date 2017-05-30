package com.siemens.assignment.entity.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.assignment.entity.Address;
import com.siemens.assignment.entity.Employee;
import com.siemens.assignment.repository.EmployeeRepository;

@Component
public class EmployeeEntityManager {

	@Autowired
	private EmployeeRepository employeeRepo;

	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee findOne(Long id) {
		return employeeRepo.findByEmployeeId(id);
	}

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	public Employee findByEmployeeName(String name) {
		return employeeRepo.findByEmployeeName(name);
	}
	
	public Employee findByEmployeeCode(String code) {
		return employeeRepo.findByCode(code);
	}

	public Employee findByEmployeeAddress(Address address) {
		return employeeRepo.findByEmployeeAddress(address);
	}

}
