package com.hieudoanm.kotlinbackendstarter.model.task

import org.jetbrains.annotations.NotNull

data class TaskRequest (
	var title: String = "",

	var description: String = "",

	var listId: String = "",

	var completed: Boolean = false,
)
