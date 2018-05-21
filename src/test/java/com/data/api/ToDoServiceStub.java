package com.data.api;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService{

	public List<String> retrieveToDos(String user) {
		
		return Arrays.asList("Learn Spring MVC","Learn Spring","Learn to do Dance");
	}

	public void daleteToDo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
