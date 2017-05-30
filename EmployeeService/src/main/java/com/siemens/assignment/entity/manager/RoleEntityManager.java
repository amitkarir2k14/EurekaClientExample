package com.siemens.assignment.entity.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.assignment.entity.Role;
import com.siemens.assignment.repository.RoleRepository;

@Component
public class RoleEntityManager {

	@Autowired
	private RoleRepository roleRepo;

	public Role save(Role role) {
		return roleRepo.save(role);
	}

	public Role findOne(Long id) {
		return roleRepo.findByRoleId(id);
	}

	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	public Role findByRoleName(String name) {
		return roleRepo.findByRoleName(name);
	}

}
