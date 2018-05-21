package com.business;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ListTest {

	@Test
	@Ignore
	public void test() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	@Ignore
	public void returnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	@Ignore
	public void getMethodTest() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("HEY");
		assertEquals("HEY", listMock.get(0));
	}
	
	@Test
	@Ignore
	public void antMatchers() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("HEY");
		assertEquals("HEY", listMock.get(0));
	}
	
	@Test
	public void usingBDD() {
		// given
		List listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("HEY");
		
		// when
		String name=(String) listMock.get(1);
		
		// then
		assertThat(name, is("HEY"));
	}

}
