package days;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DaySevenTest {

	@Test
	public void getAnswerPartOne_with_simple_input() {

		List<String> data = Arrays.asList(
		"Step C must be finished before step A can begin.",
		"Step C must be finished before step F can begin.",
		"Step A must be finished before step B can begin.",
		"Step A must be finished before step D can begin.",
		"Step B must be finished before step E can begin.",
		"Step D must be finished before step E can begin.",
		"Step F must be finished before step E can begin.");

		DaySeven daySeven = new DaySeven(data);
		assertEquals("CABDFE", daySeven.getAnswerPartOne());

	}

	@Test
	public void getAnswerPartTwo_with_simple_input() {

		List<String> data = Arrays.asList(
				"Step C must be finished before step A can begin.",
				"Step C must be finished before step F can begin.",
				"Step A must be finished before step B can begin.",
				"Step A must be finished before step D can begin.",
				"Step B must be finished before step E can begin.",
				"Step D must be finished before step E can begin.",
				"Step F must be finished before step E can begin.");

		DaySeven daySeven = new DaySeven(data);
		DaySeven.AMOUNT_OF_WORKERS = 2;
		DaySeven.BASE_JOB_TIME = 0;
		assertEquals(15, daySeven.getAnswerPartTwo().intValue());
	}

}
