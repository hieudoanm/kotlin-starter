package com.hieudoanm.kotlinbackendstarter.repository

import com.hieudoanm.kotlinbackendstarter.model.task.TaskDto
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface TaskRepository: CrudRepository<TaskDto, String> {
	@Modifying
	@Query("insert into public.tasks (\"id\", \"title\", \"description\", \"listId\", \"completed\") values (:id, :title, :description, :listId, :completed)")
	fun create(
		@Param("id") id: String,
		@Param("title") title: String,
		@Param("description") description: String,
		@Param("listId") listId: String,
		@Param("completed") completed: Boolean
	);
}
