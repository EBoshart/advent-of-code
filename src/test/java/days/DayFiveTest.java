package days;

import static org.junit.jupiter.api.Assertions.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DayFiveTest {

	@Test
	public void getStringWithoutPolarizedCharacters_with_simple_input() {
		DayFive dayFive = new DayFive("dabAcCaCBAcCcaDA");
		int result = dayFive.getAnswerPartOne();
		assertEquals("dabCBAcaDA".length(), result);
	}

	@Test
	public void getLengthOfStringWithoutPolarizedCharactersAfterRemovingBestCharacter() {
		DayFive dayFive = new DayFive("dabAcCaCBAcCcaDA");
		int result = dayFive.getAnswerPartTwo();
		assertEquals(4, result);
	}
}
