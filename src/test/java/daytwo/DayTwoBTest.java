package daytwo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

public class DayTwoBTest {

	@Test
	public void getCommonCharacters_two_strings() {
		String a = "abcdef";
		String b = "abcxef";
		DayTwoB dayTwoB = new DayTwoB(Arrays.asList(a, b));
		String result = dayTwoB.getCommonCharacters();
		assertEquals("abcef", result);
	}

	@Test
	public void getCommonCharacters_multiple_strings() {

		List<String> strings = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye",  "wvxyz");
		DayTwoB dayTwoB = new DayTwoB(strings);
		String result = dayTwoB.getCommonCharacters();
		assertEquals("fgij", result);
	}
}
