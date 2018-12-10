package advent.days;

import java.util.*;

import advent.base.*;

@Solve
public class DayOne extends Base {

	private final List<String> data;

	public DayOne(List<String> data) {

		this.data = data;
	}

	@Override
	public Integer getAnswerPartOne() {

		return this.data.stream().mapToInt(Integer::parseInt).sum();
	}

	@Override
	public Integer getAnswerPartTwo() {

		Set<Integer> frequencies = new HashSet<>();
		frequencies.add(0);
		int index = 0;
		Integer oldFrequency = 0;
		while (true) {
			int newFrequency = oldFrequency + Integer.parseInt(data.get(index));
			if (frequencies.contains(newFrequency))
				return newFrequency;
			frequencies.add(newFrequency);
			index++;
			oldFrequency = newFrequency;
			if (index == data.size())
				index = 0;
		}
	}
}
