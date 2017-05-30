package com.siemens.assignment.entity.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.assignment.entity.Department;
import com.siemens.assignment.repository.DepartmentRepository;

@Component
public class DepartmentEntitymanager {

	@Autowired
	private DepartmentRepository deptRepo;

	public Department save(Department department) {
		return deptRepo.save(department);
	}

	public Department findOne(Long id) {
		return deptRepo.findOne(id);
	}

	public List<Department> findAll() {
		return deptRepo.findAll();
	}

	public Department findByName(String name) {
		return deptRepo.findByDeptName(name);
	}
}
