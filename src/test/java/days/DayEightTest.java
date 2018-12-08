package days;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DayEightTest {

	@Test
	public void getAnswerPartOne_simple_input() {
		List<String> data = Collections.singletonList("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");
		DayEight dayEight = new DayEight(data);
		int result = dayEight.getAnswerPartOne();
		assertEquals(138, result);
	}

	@Test
	public void getAnswerPartOne_other_input() {
		List<String> data = Collections.singletonList("2 3 1 3 0 1 1 10 11 12 1 1 0 1 99 2 1 1 2");
		DayEight dayEight = new DayEight(data);
		int result = dayEight.getAnswerPartOne();
		assertEquals(139, result);
	}


	@Test
	public void getAnswerPartTwo_simple_input() {
		List<String> data = Collections.singletonList("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");
		DayEight dayEight = new DayEight(data);
		int result = dayEight.getAnswerPartTwo();
		assertEquals(66, result);
	}

	@Test
	public void getAnswerPartTwo_other_input() {
		List<String> data = Collections.singletonList("2 3 1 1 0 3 10 11 12 1 1 1 0 1 99 2 1 1 2");
		DayEight dayEight = new DayEight(data);
		int result = dayEight.getAnswerPartTwo();
		assertEquals(66, result);
	}
}
