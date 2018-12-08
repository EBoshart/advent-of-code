package days;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DayFourTest {

	@Test
	public void getGuardTimesMinutesAsleep_simple_input() {

		List<String> data = Arrays.asList(
		"[1518-11-01 00:00] Guard #10 begins shift",
		"[1518-11-01 00:05] falls asleep",
		"[1518-11-01 00:25] wakes up",
		"[1518-11-01 00:30] falls asleep",
		"[1518-11-01 00:55] wakes up",
		"[1518-11-01 23:58] Guard #99 begins shift",
		"[1518-11-02 00:40] falls asleep",
		"[1518-11-02 00:50] wakes up",
		"[1518-11-03 00:05] Guard #10 begins shift",
		"[1518-11-03 00:24] falls asleep",
		"[1518-11-03 00:29] wakes up",
		"[1518-11-04 00:02] Guard #99 begins shift",
		"[1518-11-04 00:36] falls asleep",
		"[1518-11-04 00:46] wakes up",
		"[1518-11-05 00:03] Guard #99 begins shift",
		"[1518-11-05 00:45] falls asleep",
		"[1518-11-05 00:55] wakes up");

		DayFour dayFour = new DayFour(data);
		int result = dayFour.getAnswerPartOne();
		assertEquals(240, result);
	}

	@Test
	public void getGuardTimesMinuteMostSpentAsleep_simple_input() {

		List<String> data = Arrays.asList(
				"[1518-11-01 00:00] Guard #10 begins shift",
				"[1518-11-01 00:05] falls asleep",
				"[1518-11-01 00:25] wakes up",
				"[1518-11-01 00:30] falls asleep",
				"[1518-11-01 00:55] wakes up",
				"[1518-11-01 23:58] Guard #99 begins shift",
				"[1518-11-02 00:40] falls asleep",
				"[1518-11-02 00:50] wakes up",
				"[1518-11-03 00:05] Guard #10 begins shift",
				"[1518-11-03 00:24] falls asleep",
				"[1518-11-03 00:29] wakes up",
				"[1518-11-04 00:02] Guard #99 begins shift",
				"[1518-11-04 00:36] falls asleep",
				"[1518-11-04 00:46] wakes up",
				"[1518-11-05 00:03] Guard #99 begins shift",
				"[1518-11-05 00:45] falls asleep",
				"[1518-11-05 00:55] wakes up");

		DayFour dayFour = new DayFour(data);
		int result = dayFour.getAnswerPartTwo();
		assertEquals(4455, result);
	}
}