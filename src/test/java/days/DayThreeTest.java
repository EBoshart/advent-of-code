package days;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import advent.days.*;
import org.junit.jupiter.api.*;

public class DayThreeTest {

	@Test
	public void calculateOverlappingSquares_with_simple_input() {

		List<String> data = Arrays.asList("#1 @ 1, 1: 1x1", "#2 @ 1,1: 2x2");
		DayThree dayThree =  new DayThree(data);
		long result = dayThree.getAnswerPartOne();
		assertEquals(1, result);

	}

	@Test
	public void calculateOverlappingSquares_with_more_input() {
		List<String> data = Arrays.asList("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2");
		DayThree dayThree =  new DayThree(data);
		long result = dayThree.getAnswerPartOne();
		assertEquals(4, result);
	}



	@Test
	public void getUniqueSquareId_with_simple_input() {

		List<String> data = Arrays.asList("#1 @ 1, 1: 1x1", "#2 @ 1,1: 2x2", "#3 @ 4, 4: 2x2");
		DayThree dayThree =  new DayThree(data);
		String  result = dayThree.getAnswerPartTwo();
		assertEquals("#3", result);

	}


}
