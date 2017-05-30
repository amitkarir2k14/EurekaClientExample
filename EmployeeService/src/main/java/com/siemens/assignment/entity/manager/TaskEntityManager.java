package com.siemens.assignment.entity.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siemens.assignment.entity.Task;
import com.siemens.assignment.repository.TaskRepository;

@Component
public class TaskEntityManager {

	@Autowired
	private TaskRepository taskRepo;

	public Task save(Task task) {
		return taskRepo.save(task);
	}

	public Task findOne(Long id) {
		return taskRepo.findByTaskId(id);
	}

	public List<Task> findAll() {
		return taskRepo.findAll();
	}

	public Task findByProjectame(String name) {
		return taskRepo.findByTaskName(name);
	}

}
