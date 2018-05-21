package com.business;

import java.util.List;

import org.junit.Test;

import com.data.api.ToDoService;
import com.data.api.ToDoServiceStub;

import static org.junit.Assert.*;

public class ToDOBusinessImplStubTest {

	@Test
	public void test() {
		ToDoService toDoService=new ToDoServiceStub();
		ToDOBusinessImpl businessImpl=new ToDOBusinessImpl(toDoService);
		List<String> filteredTodos=businessImpl.retrieveToDosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
