package com.hieudoanm.kotlinbackendstarter.controller

import com.hieudoanm.kotlinbackendstarter.model.error.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.io.PrintWriter
import java.io.StringWriter

@ControllerAdvice
class ErrorController {
	@ExceptionHandler(
		NoSuchElementException::class,
		IndexOutOfBoundsException::class,
		KotlinNullPointerException::class
	)
	fun notFoundException(e: Exception): ResponseEntity<ErrorResponse> {
		return generateErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", e)
	}

	private fun generateErrorResponse(
		status: HttpStatus,
		message: String,
		e: Exception
	): ResponseEntity<ErrorResponse> {
		// converting the exception stack trace to a string
		val sw = StringWriter()
		val pw = PrintWriter(sw)
		e.printStackTrace(pw)
		val stackTrace = sw.toString()

		// example: logging the stack trace
		// log.debug(stackTrace)

		// environment-based logic
		val stackTraceMessage =
			when (System.getenv("ENV").uppercase()) {
				"STAGING" -> stackTrace // returning the stack trace
				"PRODUCTION" -> null // returning no stack trace
				else -> stackTrace // default behavior
			}

		return ResponseEntity(ErrorResponse(status, message, stackTraceMessage), status)
	}
}
