package com.nisum.powermock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.in28minutes.powermock.Dependency;
import com.in28minutes.powermock.SystemUnderTest;
import com.in28minutes.powermock.UtilityClass;


@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class StaticMock {
	
	/*@Rule
	public MockitoRule mockitoRule=MockitoJUnit.rule();*/
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Test
	public void test() {
		List<Integer> stats = Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result=systemUnderTest.methodCallingAStaticMethod();
		
		assertEquals(150, result);
		
	}
	
	
}
