package com.hieudoanm.kotlinbackendstarter.model

data class TaskRequest (
	var title: String = "",
	var description: String = "",
	var completed: Boolean = false,
)
