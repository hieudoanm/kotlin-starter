package com.hieudoanm.kotlinbackendstarter.service

import com.hieudoanm.kotlinbackendstarter.model.list.ListDto
import com.hieudoanm.kotlinbackendstarter.model.list.ListRequest
import com.hieudoanm.kotlinbackendstarter.repository.ListRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ListService(private val listRepository: ListRepository) {
	fun findLists(): List<ListDto> {
		return listRepository.findAll().toList();
	}

	fun createList(newList: ListRequest) {
		val id = UUID.randomUUID().toString()
		listRepository.create(id, newList.title, newList.description, newList.userId)
	}

	fun findList(id: String): ListDto {
		return listRepository.findById(id).orElse(null);
	}

	fun updateList(id: String, listRequest: ListRequest): ListDto {
		val list: ListDto = listRepository.findById(id).orElse(null);
		list.title = listRequest.title;
		list.description = listRequest.description;
		list.userId = listRequest.userId;
		return listRepository.save(list);
	}

	fun deleteList(id: String) {
		listRepository.deleteById(id);
	}
}
