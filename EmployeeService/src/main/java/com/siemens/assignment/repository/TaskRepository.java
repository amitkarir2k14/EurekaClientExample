package com.siemens.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siemens.assignment.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	public Task findByTaskId(Long id);

	public Task findByTaskName(String name);
}
