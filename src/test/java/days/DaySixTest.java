package days;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DaySixTest {

	@Test
	public void getAnswerPartOne_simple_input() {

		List<String> data = Arrays.asList(
		"1, 1",
		"1, 6",
		"8, 3",
		"3, 4",
		"5, 5",
		"8, 9");

		DaySix daySix = new DaySix(data);
		int result = daySix.getAnswerPartOne();
		assertEquals(17, result);
	}

	@Test
	public void getAnswerPartTwo_simple_input() {

		List<String> data = Arrays.asList(
				"1, 1",
				"1, 6",
				"8, 3",
				"3, 4",
				"5, 5",
				"8, 9");

		DaySix daySix = new DaySix(data);
		DaySix.MAX_TOTAL_NEIGHBOUR_DISTANCE = 32;
		int result = daySix.getAnswerPartTwo();
		assertEquals(16, result);
	}
}
