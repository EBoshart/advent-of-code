package days;

import static org.junit.jupiter.api.Assertions.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DayNineTest {

	@Test
	public void getAnswerPartOne() {

		assertEquals(8317, new DayNine(1618, 10).getAnswerPartOne().intValue());
		assertEquals(54718, new DayNine(6111, 21).getAnswerPartOne().intValue());
		assertEquals(2764, new DayNine(1104, 17).getAnswerPartOne().intValue());
		assertEquals(37305, new DayNine(5807, 30).getAnswerPartOne().intValue());
		assertEquals(146373, new DayNine(7999, 13).getAnswerPartOne().intValue());
	}

	@Test
	public void getAnswerPartTwo() {

		DayNine dayNine = new DayNine(7192000, 403);
		assertEquals(3668541094L, dayNine.getAnswerPartOne().longValue());
	}
}
