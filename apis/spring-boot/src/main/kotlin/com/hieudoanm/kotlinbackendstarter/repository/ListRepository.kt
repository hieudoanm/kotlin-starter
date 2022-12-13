package com.hieudoanm.kotlinbackendstarter.repository

import com.hieudoanm.kotlinbackendstarter.model.list.ListDto
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ListRepository: CrudRepository<ListDto, String> {
	@Modifying
	@Query("insert into public.tasks (\"id\", \"title\", \"description\", \"userId\") values (:id, :title, :title, :userId)")
	fun create(
		@Param("id") id: String,
		@Param("title") title: String,
		@Param("description") description: String,
		@Param("userId") userId: String
	);
}
