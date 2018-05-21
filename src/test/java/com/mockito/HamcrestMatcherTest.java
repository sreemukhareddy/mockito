package com.mockito;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void test() {
		List<Integer> scores=Arrays.asList(1,2,3,4);
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(1,2));
		assertThat(scores, everyItem(greaterThan(0)));
		assertThat(scores, everyItem(lessThan(5)));
	}

}
