package days;

import static org.junit.jupiter.api.Assertions.assertEquals;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DayElevenTest {

	@Test
	public void getAnswerPartOne() {

		DayEleven dayEleven = new DayEleven();
		DayEleven.serialNumber = 18;
		DayEleven.size = 3;
		assertEquals("33,45", dayEleven.getAnswerPartOne());
	}

	@Test
	public void getAnswerPartTwo() {

		DayEleven dayEleven = new DayEleven();
		DayEleven.serialNumber = 18;
		assertEquals("90,269,16", dayEleven.getAnswerPartTwo());
	}
}
