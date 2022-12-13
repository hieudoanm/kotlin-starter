package com.hieudoanm.kotlinbackendstarter.controller

import com.hieudoanm.kotlinbackendstarter.model.list.ListDto
import com.hieudoanm.kotlinbackendstarter.model.list.ListRequest
import com.hieudoanm.kotlinbackendstarter.service.ListService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lists")
class ListController(private val listService: ListService) {
	@GetMapping
	fun index(): List<ListDto> = listService.findLists()

	@PostMapping
	fun post(@RequestBody list: ListRequest) = listService.createList(list)

	@GetMapping("/{id}")
	fun index(@PathVariable(value = "id") id: String): ListDto = listService.findList(id);

	@PutMapping("/{id}")
	fun put(@PathVariable(value = "id") id: String, @RequestBody list: ListRequest): ListDto = listService.updateList(id, list);

	@DeleteMapping("/{id}")
	fun delete(@PathVariable(value = "id") id: String) = listService.deleteList(id)
}
