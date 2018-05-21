package com.data.api;

import java.util.List;

public interface ToDoService {
	
	public List<String> retrieveToDos(String user);
	public void daleteToDo(String todo);

}
