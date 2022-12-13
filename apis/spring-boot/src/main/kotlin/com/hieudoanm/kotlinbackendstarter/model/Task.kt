package com.hieudoanm.kotlinbackendstarter.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "tasks", schema = "public")
data class Task (
	@Id
	@Column("id")
	val id: String,

	@Column("title")
	var title: String,

	@Column("description")
	var description: String,

	@Column("completed")
	var completed: Boolean,
)
