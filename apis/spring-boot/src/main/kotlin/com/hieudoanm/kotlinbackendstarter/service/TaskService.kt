package com.hieudoanm.kotlinbackendstarter.service

import com.hieudoanm.kotlinbackendstarter.model.task.TaskDto
import com.hieudoanm.kotlinbackendstarter.model.task.TaskRequest
import com.hieudoanm.kotlinbackendstarter.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(private val taskRepository: TaskRepository) {
	fun findTasks(): List<TaskDto> {
		return taskRepository.findAll().toList();
	}

	fun createTask(newTask: TaskRequest) {
		val id = UUID.randomUUID().toString()
		taskRepository.create(id, newTask.title, newTask.description, newTask.listId, newTask.completed)
	}

	fun findTask(id: String): TaskDto {
		return taskRepository.findById(id).orElse(null);
	}

	fun updateTask(id: String, taskRequest: TaskRequest): TaskDto {
		val taskDto: TaskDto = taskRepository.findById(id).orElse(null);
		taskDto.title = taskRequest.title;
		taskDto.description = taskRequest.description;
		taskDto.completed = taskRequest.completed;
		return taskRepository.save(taskDto);
	}

	fun deleteTask(id: String) {
		taskRepository.deleteById(id);
	}
}
