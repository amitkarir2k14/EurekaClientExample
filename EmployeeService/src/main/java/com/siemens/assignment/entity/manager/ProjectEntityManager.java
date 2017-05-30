package com.siemens.assignment.entity.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.assignment.entity.Project;
import com.siemens.assignment.repository.ProjectRepository;

@Component
public class ProjectEntityManager {

	@Autowired
	private ProjectRepository projectRepo;
	
	public Project save(Project project) {
		return projectRepo.save(project);
	}
	
	public Project findOne(Long id) {
		return projectRepo.findByProjectId(id);
	}
	
	public List<Project> findAll() {
		return projectRepo.findAll();
	}
	
	public Project findByProjectame(String name) {
		return projectRepo.findByProjectName(name);
	}
	
	public Project findByProjectCode(String code) {
		return projectRepo.findByProjectCode(code);
	}
}
