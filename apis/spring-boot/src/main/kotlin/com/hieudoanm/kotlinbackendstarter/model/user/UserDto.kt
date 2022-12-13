package com.hieudoanm.kotlinbackendstarter.model.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users", schema = "public")
class UserDto (
	@Id
	@Column("id")
	val id: String,

	@Column("username")
	var username: String,

	@Column("password")
	var password: String
)
