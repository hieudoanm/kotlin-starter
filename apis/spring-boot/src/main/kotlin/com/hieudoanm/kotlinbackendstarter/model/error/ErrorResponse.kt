package com.hieudoanm.kotlinbackendstarter.model.error

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.util.*

class ErrorResponse(
	httpStatus: HttpStatus,
	var message: String,
	var stackTrace: String? = null
) {
	var code: Int = httpStatus.value()
	var status: String = httpStatus.name

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	val timestamp: Date = Date()

	init {
		code = httpStatus.value()
		status = httpStatus.name
	}
}
