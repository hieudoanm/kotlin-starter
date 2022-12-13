package com.hieudoanm.kotlinbackendstarter.model.list

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table(name = "lists", schema = "public")
class ListDto (
	@Id
	@Column("id")
	val id: String,

	@Column("title")
	var title: String,

	@Column("description")
	var description: String,

	@Column("user_id")
	var userId: String,

	@Column("created_at")
	var createdAt: Date,

	@Column("updated_at")
	var updatedAt: Date
)

