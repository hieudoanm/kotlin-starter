package com.hieudoanm.kotlinbackendstarter.controller

import com.hieudoanm.kotlinbackendstarter.model.user.UserDto
import com.hieudoanm.kotlinbackendstarter.model.user.UserRequest
import com.hieudoanm.kotlinbackendstarter.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
	@GetMapping
	fun index(): List<UserDto> = userService.findUsers()

	@PostMapping
	fun post(@RequestBody user: UserRequest) = userService.createUser(user)

	@GetMapping("/{id}")
	fun index(@PathVariable(value = "id") id: String): UserDto = userService.findUser(id);

	@PutMapping("/{id}")
	fun put(@PathVariable(value = "id") id: String, @RequestBody user: UserRequest): UserDto = userService.updateUser(id, user);

	@DeleteMapping("/{id}")
	fun delete(@PathVariable(value = "id") id: String) = userService.deleteUser(id)

}
