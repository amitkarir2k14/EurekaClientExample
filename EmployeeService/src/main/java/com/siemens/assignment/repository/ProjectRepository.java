package com.siemens.assignment.repository;

import org.springframework.stereotype.Repository;

import com.siemens.assignment.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectId(Long id);

	public Project findByProjectCode(String code);

	public Project findByProjectName(String name);

}
