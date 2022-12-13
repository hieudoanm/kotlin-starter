package com.hieudoanm.kotlinbackendstarter.service

import com.hieudoanm.kotlinbackendstarter.model.user.UserDto
import com.hieudoanm.kotlinbackendstarter.model.user.UserRequest
import com.hieudoanm.kotlinbackendstarter.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {
	fun findUsers(): List<UserDto> {
		return userRepository.findAll().toList();
	}

	fun createUser(newUser: UserRequest) {
		val id = UUID.randomUUID().toString()
		userRepository.create(id, newUser.username, newUser.password)
	}

	fun findUser(id: String): UserDto {
		return userRepository.findById(id).orElse(null);
	}

	fun updateUser(id: String, userRequest: UserRequest): UserDto {
		val userDto: UserDto = userRepository.findById(id).orElse(null);
		userDto.username = userRequest.username;
		userDto.password = userRequest.password;
		return userRepository.save(userDto);
	}

	fun deleteUser(id: String) {
		userRepository.deleteById(id);
	}
}
