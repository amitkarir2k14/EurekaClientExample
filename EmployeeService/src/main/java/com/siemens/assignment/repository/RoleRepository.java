package com.siemens.assignment.repository;

import org.springframework.stereotype.Repository;

import com.siemens.assignment.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRoleId(Long id);

	public Role findByRoleName(String name);

}
