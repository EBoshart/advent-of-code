package days.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import days.*;
import org.junit.jupiter.api.*;

public class DayOneTest {

	@Test
	public void test_with_two_inputs() {
		DayOne dayOne = new DayOne(Arrays.asList("-1", "+3"));
		int result = dayOne.getAnswerPartOne();
		assertEquals(2, result);
	}


	@Test
	public void test_with_multiple_inputs() {
		DayOne dayOne = new DayOne(Arrays.asList("+1", "-2", "+3", "+1"));
		int result = dayOne.getAnswerPartOne();
		assertEquals(3, result);
	}

	@Test
	public void test_with_single_loop() {
		DayOne dayOne = new DayOne(Arrays.asList("+1", "-1"));
		int result = dayOne.getAnswerPartTwo();
		assertEquals(0, result);
	}

	@Test
	public void test_with_mulitple_loops() {
		DayOne dayOne = new DayOne(Arrays.asList("-6", "+3", "+8", "+5", "-6"));
		int result = dayOne.getAnswerPartTwo();
		assertEquals(5, result);
	}
}
