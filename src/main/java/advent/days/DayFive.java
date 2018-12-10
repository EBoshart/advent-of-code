package advent.days;

import java.util.*;
import java.util.stream.*;

import advent.base.*;

@Solve
public class DayFive implements Base {

	private String data;

	public DayFive(List<String> data) {

		this.data = data.get(0);
	}

	public DayFive(String data) {

		this.data = data;
	}

	public Integer getAnswerPartOne() {

		int index = 0;

		while (index != data.length() - 1) {
			Character previousChar = data.charAt(index);
			Character currentChar = data.charAt(index + 1);

			if (previousChar + 32 == currentChar || previousChar - 32 == currentChar) {
				data = data.substring(0, index) + data.substring(index + 2);
				index = Math.max(0, index - 1);
			} else
				index++;
		}
		return data.length();
	}

	public Integer getAnswerPartTwo() {

		return IntStream.range(0, 26).map(i -> {
			char lowerCase = (char) ('a' + i);
			char upperCase = (char) (i - 32 + 'a');

			String s = ("" + lowerCase + upperCase);
			return new DayFive(Collections.singletonList(data.replaceAll("[" + s + "]", ""))).getAnswerPartOne();
		}).min().orElseThrow(() -> new IllegalStateException("no minimum found"));
	}
}
