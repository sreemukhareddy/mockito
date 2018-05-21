package com.business;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.data.api.ToDoService;

public class ToDOBusinessImplStubMock {

	@Test
	@Ignore
	public void test() {
		/*ToDoService toDoService=new ToDoServiceStub();
		ToDOBusinessImpl businessImpl=new ToDOBusinessImpl(toDoService);
		List<String> filteredTodos=businessImpl.retrieveToDosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());*/
		
		ToDoService doService=mock(ToDoService.class);
		when(doService.retrieveToDos("Dummy")).thenReturn(Arrays.asList("Spring","Spring","Spring"));
		//when(doService.retrieveToDos("Dummy")).thenReturn(null);
		ToDOBusinessImpl businessImpl=new ToDOBusinessImpl(doService);
		List<String> filteredTodos=businessImpl.retrieveToDosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	@Ignore
	public void testToDoDeleteNitReleatedToSpring() {
		
		
		// define argument captor
		
		ToDoService doService=mock(ToDoService.class);
		List<String> todos=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance");
		given(doService.retrieveToDos("Dummy")).willReturn(todos);
		ToDOBusinessImpl businessImpl=new ToDOBusinessImpl(doService);
		
		// when
		businessImpl.deleteToDoNotRelatedToSpring("Dummy");
		
		// then
		//verify(doService).daleteToDo("Learn to dance");
		then(doService).should().daleteToDo("Learn to dance");
		then(doService).should(never()).daleteToDo("Learn Spring MVC");
	}
	
	@Test
	public void testArgumentToDoDeleteNitReleatedToSpring() {
		
		// declare argument captor
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		
		// define argument captor
		
		ToDoService doService=mock(ToDoService.class);
		List<String> todos=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to dance");
		given(doService.retrieveToDos("Dummy")).willReturn(todos);
		ToDOBusinessImpl businessImpl=new ToDOBusinessImpl(doService);
		
		// when
		businessImpl.deleteToDoNotRelatedToSpring("Dummy");
		
		// then
		//verify(doService).daleteToDo("Learn to dance");
		then(doService).should(times(2)).daleteToDo(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(),is(2));
		
	}

}
