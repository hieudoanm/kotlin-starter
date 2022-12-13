package com.hieudoanm.kotlinbackendstarter.repository

import com.hieudoanm.kotlinbackendstarter.model.user.UserDto
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository: CrudRepository<UserDto, String> {
	@Modifying
	@Query("insert into public.tasks (\"id\", \"username\", \"password\") values (:id, :username, :username)")
	fun create(
		@Param("id") id: String,
		@Param("username") username: String,
		@Param("password") password: String
	);
}
