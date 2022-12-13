package com.hieudoanm.kotlinbackendstarter.controller

import com.hieudoanm.kotlinbackendstarter.model.task.TaskDto
import com.hieudoanm.kotlinbackendstarter.model.task.TaskRequest
import com.hieudoanm.kotlinbackendstarter.service.TaskService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {
	@GetMapping
	fun index(): List<TaskDto> = taskService.findTasks()

	@PostMapping
	fun post(@RequestBody task: TaskRequest) = taskService.createTask(task)

	@GetMapping("/{id}")
	fun index(@PathVariable(value = "id") id: String): TaskDto = taskService.findTask(id);

	@PutMapping("/{id}")
	fun put(@PathVariable(value = "id") id: String, @RequestBody task: TaskRequest): TaskDto = taskService.updateTask(id, task);

	@DeleteMapping("/{id}")
	fun delete(@PathVariable(value = "id") id: String) = taskService.deleteTask(id)
}
