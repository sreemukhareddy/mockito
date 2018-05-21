package com.business;

import java.util.ArrayList;
import java.util.List;

import com.data.api.ToDoService;

public class ToDOBusinessImpl {
	
	private ToDoService toDoService;

	public ToDOBusinessImpl(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	public List<String> retrieveToDosRelatedToSpring(String user){
		List<String> filteredToDos = new ArrayList<String>();
		List<String> todos=toDoService.retrieveToDos(user);
		for(String todo : todos) {
			if(todo.contains("Spring")) {
				filteredToDos.add(todo);
			}
		}
		return filteredToDos;
	}
	
	public void deleteToDoNotRelatedToSpring(String user) {
		List<String> todos=toDoService.retrieveToDos(user);
		for(String todo : todos) {
			if(!todo.contains("Spring")) {
				toDoService.daleteToDo(todo);
			}
		}
		
	}

}
