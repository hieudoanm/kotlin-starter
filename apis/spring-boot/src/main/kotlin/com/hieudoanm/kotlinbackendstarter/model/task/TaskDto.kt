package com.hieudoanm.kotlinbackendstarter.model.task

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table(name = "tasks", schema = "public")
data class TaskDto (
	@Id
	@Column("id")
	val id: String,

	@Column("title")
	var title: String,

	@Column("description")
	var description: String,

	@Column("list_id")
	var listId: String,

	@Column("completed")
	var completed: Boolean,

	@Column("created_at")
	var createdAt: Date,

	@Column("updated_at")
	var updatedAt: Date
)
