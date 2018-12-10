package advent.days;

import java.util.*;
import java.util.stream.*;

import advent.base.*;

@Solve
public class DayTwo implements Base {

	private List<String> data;
	private int twoCount;
	private int threeCount;

	public DayTwo(List<String> data) {

		this.data = data;
	}

	@Override
	public Integer getAnswerPartOne() {

		data.forEach(this::checkString);
		return twoCount * threeCount;
	}

	private void checkString(String s) {

		Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		if (map.values().contains(2L))
			twoCount++;
		if (map.values().contains(3L))
			threeCount++;
	}

	@Override
	public String getAnswerPartTwo() {

		for (int i = 0; i < data.size() - 1; i++) {
			for (int j = i + 1; j < data.size(); j++) {
				String result = checkStrings(data.get(i), data.get(j));
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	private String checkStrings(String a, String b) {

		int index = 0;
		int indexOfDifferentChar = 0;
		while (index < a.length()) {
			if (a.charAt(index) == b.charAt(index)) {
				index++;
				continue;
			}
			if (indexOfDifferentChar != 0)
				return null;
			indexOfDifferentChar = index;
			index++;

		}

		return a.substring(0, indexOfDifferentChar) + a.substring(indexOfDifferentChar + 1);
	}
}
