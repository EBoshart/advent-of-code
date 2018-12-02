package daytwo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

public class DayTwoTest {

	@Test
	public void getCheckSum_with_one_input_string() {

		DayTwo dayTwo = new DayTwo(Collections.singletonList("aabbb"));
		int checkSum = dayTwo.getCheckSum();

		assertEquals(1, checkSum);
	}

	@Test
	public void getCheckSum_with_multiple_input_string() {

		DayTwo dayTwo = new DayTwo(Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"));
		int checkSum = dayTwo.getCheckSum();
		assertEquals(12, checkSum);

	}

}
