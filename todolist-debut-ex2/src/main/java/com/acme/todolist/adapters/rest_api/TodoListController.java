package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.service.AddTodoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItem addTodoItemQuery;

	
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery,AddTodoItem addTodoItemQuery ) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.addTodoItemQuery= addTodoItemQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	// A compléter

	@PostMapping("/todos")
	public ResponseEntity<TodoItem> ajouterItem(@RequestBody TodoItem item) {
		addTodoItemQuery.addTodoItem(item);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
	
	
}
